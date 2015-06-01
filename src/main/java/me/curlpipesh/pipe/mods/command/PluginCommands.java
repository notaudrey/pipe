package me.curlpipesh.pipe.mods.command;

import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.commands.Command;
import me.curlpipesh.pipe.commands.PluginCommand;
import me.curlpipesh.pipe.event.ChatSend;
import me.curlpipesh.pipe.util.ChatHelper;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

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
        commands.addAll(PluginManager.getInstance().getManagedObjects().stream().map(PluginCommand::new).collect(Collectors.toList()));
    }

    /**
     * Attempts to find a command for the given String, and runs it.
     *
     * @param command The full String of the given command (name + args)
     */
    private void runCommand(String command) {
        String[] temp = command.split(" ");
        String cmd = temp[0];
        String[] args = new String[temp.length - 1];
        System.arraycopy(temp, 1, args, 0, args.length);
        for(Command e : commands) {
            if(e.getName().equalsIgnoreCase(cmd)) {
                run(e, command, args);
                return;
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
            e.run(command, args);
        }
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
