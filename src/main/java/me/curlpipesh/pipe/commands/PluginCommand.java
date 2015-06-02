package me.curlpipesh.pipe.commands;

import lombok.Getter;
import me.curlpipesh.lib.config.Configurable;
import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.lib.util.Toggleable;
import me.curlpipesh.pipe.util.ChatHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Command used for the manipulation of a plugin. Ideally, these would
 * automatically generate themselves based on the plugin passed in.
 *
 * @author c
 * @since 5/27/15
 */
public class PluginCommand implements Command {
    @Getter
    private final Plugin plugin;

    private final String name;

    @Getter
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Command> subcommands = new ArrayList<>();

    public PluginCommand(Plugin plugin) {
        this.plugin = plugin;
        name = plugin.getName().toLowerCase().replaceAll("\\W+", "");

        // Automagic generation of subcommands for options. Yes, this is fairly
        // messy, but there really isn't much that can be done to make this
        // cleaner, short of refactoring it into an external class or a proper
        // inner class.
        //
        // TODO Refactor out?
        if(plugin instanceof Configurable) {
            if(((Configurable) plugin).getOptions() != null) {
                ((Configurable) plugin).getOptions().stream().sequential().forEach(o -> {
                    final String n = o.name().toLowerCase().replaceAll("\\W+", "");
                    subcommands.add(new Command() {
                        @Override
                        public boolean run(String command, String[] args) {
                            if(args.length == 0) {
                                ChatHelper.warn("You didn't provide a value for '§c" + name + "." + o.name() + "§r'!");
                                return false;
                            }
                            try {
                                o.set(args[0]);
                                ChatHelper.log("Successfully changed value for '§a" + name + "." + o.name() + "§r' to '§a"
                                        + args[0] + "§r'!");
                                return true;
                            } catch(Exception e) {
                                ChatHelper.warn("Failed to set '§c" + name + "§r.§c" + o.name() + "§r' to '§c" + args[0] + "§r': "
                                        + e.getClass().getSimpleName());
                                e.printStackTrace();
                                return false;
                            }
                        }

                        @Override
                        public String getName() {
                            return n;
                        }

                        @Override
                        public String getDescription() {
                            return "Manipulates the value of the '" + o.name() + "' option for the '" + plugin.getName() + "' plugin";
                        }

                        @Override
                        public List<Command> getSubcommands() {
                            return null;
                        }

                        @Override
                        public boolean takesRawInput() {
                            return true;
                        }

                        @Override
                        public void setRawInput(boolean e) {
                        }
                    });
                });
            }
        }
    }

    @Override
    public boolean run(String command, String[] args) {
        if(args.length == 0) {
            if(plugin instanceof Toggleable) {
                ((Toggleable) plugin).toggle();
                return true;
            } else if(plugin instanceof ExecutablePlugin) {
                ((ExecutablePlugin) plugin).execute();
                return true;
            } else {
                ChatHelper.warn("§cHow did you manage that?");
                return false;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Manipulates the " + getName() + " plugin.";
    }

    @Override
    public boolean takesRawInput() {
        return false;
    }

    @Override
    public void setRawInput(boolean e) {
    }
}
