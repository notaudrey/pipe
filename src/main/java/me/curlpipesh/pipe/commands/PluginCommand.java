package me.curlpipesh.pipe.commands;

import lombok.Getter;
import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.lib.util.Toggleable;

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

    public PluginCommand(Plugin plugin) {
        this.plugin = plugin;
        name = plugin.getName().toLowerCase().replaceAll("\\W+", "");
    }

    @Override
    public boolean run(String command, String[] args) {
        if(args.length == 0) {
            if(plugin instanceof Toggleable) {
                ((Toggleable)plugin).toggle();
                return true;
            } else if(plugin instanceof ExecutablePlugin) {
                ((ExecutablePlugin)plugin).execute();
                return true;
            } else {
                addChatMessage("§cHow did you manage that?");
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
    public List<Command> getSubcommands() {
        return null;
    }

    @Override
    public boolean takesRawInput() {
        return false;
    }

    @Override
    public void setRawInput(boolean e) {
    }
}
