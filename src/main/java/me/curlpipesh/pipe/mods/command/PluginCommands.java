package me.curlpipesh.pipe.mods.command;

import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.commands.Command;
import me.curlpipesh.pipe.commands.PluginCommand;
import me.curlpipesh.pipe.event.ChatSend;
import me.curlpipesh.pipe.util.ClassMapper;
import me.curlpipesh.pipe.util.helpers.ChatHelper;
import me.curlpipesh.pipe.util.helpers.Helper;
import me.curlpipesh.pipe.util.helpers.StringHelper;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Plugin for managing of a command system. Because the command system is
 * plugin-based, one is able to substitute in their own command setup for this
 * one, which is the default. In order for this to work, only two classes - the
 * simple {@link Command} and {@link me.curlpipesh.pipe.commands.PluginCommand}
 * - are prepared in advance. Note that using <tt>PluginCommand</tt> is purely
 * optional, but using <tt>Command</tt> is not: Plugins are intended to expect
 * the presence of the <tt>Command</tt> class, and therefore it would not wise
 * to ignore it.
 *
 * @author c
 * @since 5/27/15
 */
@SuppressWarnings("unused")
@Load(priority = LoadPriority.INIT_AFTER_ALL)
public class PluginCommands implements Plugin {
    /**
     * The prefix for chat-based commands
     */
    private final String prefix = ":";

    /**
     * The list of available commands
     */
    private final List<Command> commands = new ArrayList<>();

    @Override
    public void init() {
        EventManager.register(new Listener<ChatSend>() {
            @Override
            public void event(ChatSend chatSend) {
                if(chatSend.isCancelled()) {
                    return;
                }
                if(chatSend.getMessage().startsWith(prefix)) {
                    if(!chatSend.getMessage().equals(prefix)) {
                        chatSend.setCancelled(true);
                        String m = chatSend.getMessage().replaceAll("#(.*)", "");
                        m = m.substring(prefix.length());
                        runCommand(m);
                    }
                }
            }
        });
        commands.addAll(PluginManager.getInstance().getManagedObjects().stream()
                .filter(c -> !c.equals(this)).map(PluginCommand::new)
                .filter(c -> c != null).collect(Collectors.toList()));
        List<Class<?>> classes = ClassMapper.getMappedClasses().stream()
                // Is a valid command, but not the Command interface
                .filter(c -> Command.class.isAssignableFrom(c) && !Command.class.equals(c))
                // Neither PluginCommand class nor a subclass of this class or this class itself
                .filter(c -> !c.equals(PluginCommand.class) && !this.getClass().isAssignableFrom(c))
                // Not abstract or interface
                .filter(c -> !Modifier.isAbstract(c.getModifiers()) && !Modifier.isInterface(c.getModifiers()))
                // Not an inner class. Note that this will not survive obfuscation, but this doesn't really matter
                // too much as the client isn't intended to be obfuscated
                .filter(c -> !c.getName().contains("$"))
                .collect(Collectors.toList());
        commands.addAll(classes.stream().map(c -> {
            Command command = null;
            try {
                command = (Command) c.getDeclaredConstructor().newInstance();
            } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return command;
        }).filter(c -> c != null).collect(Collectors.toList()));
        Pipe.log(commands.size() + " commands loaded!");
    }

    /**
     * Attempts to find a command for the given String, and runs it.
     *
     * @param command The full String of the given command (name + args)
     */
    private void runCommand(String command) {
        List<String> similars = new ArrayList<>();
        String[] temp = command.split(" ");
        String cmd = temp[0];
        String[] args = new String[temp.length - 1];
        System.arraycopy(temp, 1, args, 0, args.length);
        if(cmd.equalsIgnoreCase("dump")) {
            commands.stream().filter(e -> e != null)
                    .forEach(e -> Helper.addChatMessage(String.format("§7Command: §c%s", e.getName())));
            return;
        }
        for(Command e : commands) {
            if(e.getName().equalsIgnoreCase(cmd)) {
                run(e, command, args);
                return;
            } else {
                if(StringHelper.levenshteinDistance(e.getName().toLowerCase(), cmd.toLowerCase()) <= 5) {
                    if(similars.size() < 5) {
                        similars.add(e.getName());
                    }
                }
            }
        }
        ChatHelper.warn("Command not found: '§c" + cmd + "§r'");
        if(!similars.isEmpty()) {
            ChatHelper.log("Did you perhaps mean?:");
            for(String string : similars) {
                ChatHelper.log("  §7*§r " + string);
            }
        }
    }

    /**
     * Actually runs a given command. This method may recursively invoke itself
     * as it iterates through subcommands in an attempt to find one that
     * can be run.
     *
     * @param e The command to be run. May or may not be a subcommand.
     * @param command The full String of the command to be run (name + args)
     * @param args The arguments to be passed to the given command, or
     *             shortened if a subcommand must be run.
     */
    private void run(Command e, String command, String[] args) {
        if(!e.takesRawInput() && args.length > 0) {
            if(e.getSubcommands() != null) {
                e.getSubcommands().stream().filter(s -> s.getName().equalsIgnoreCase(args[0])).forEach(s -> {
                    String[] args2 = new String[args.length - 1];
                    System.arraycopy(args, 1, args2, 0, args2.length);
                    run(s, command.substring(command.split(" ")[0].length()).trim(), args2);
                });
            } else {
                ChatHelper.log("§cAttempted to use no args for '§4" + e.getName() + "§c', but it requires args!");
            }
        } else {
            try {
                if(!e.run(command, args)) {
                    ChatHelper.warn("Failed to run command: §c'" + e.getName().toLowerCase() + "'",
                            e.generateUsage() ? generateUsage(e) : e.getUsage());
                }
            } catch(Exception f) {
                ChatHelper.warn("Failed to run command '§c" + e.getName() + "§r': "
                        + f.getClass().getSimpleName(), "§cPlease check the logs for more information.");
                f.printStackTrace();
            }
        }
    }

    /**
     * Generates the usage information for a given command.
     *
     * @param command The command to generate usage for
     * @return The generate usage information
     */
    private String generateUsage(Command command) {
        StringBuilder sb = new StringBuilder();
        if(command instanceof PluginCommand) {
            sb.append(command.getName().toLowerCase()).append(" [<option> [value]]");
        } else {
            sb.append(command.getName().toLowerCase()).append(" [command [argument]]");
        }
        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return "Commands";
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public String getStatus() {
        return Status.OK;
    }

    @Override
    public void setStatus(String status) {
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }
}
