package me.curlpipesh.pipe.commands;

import lombok.Getter;
import me.curlpipesh.lib.plugin.Plugin;

/**
 * Command used for the manipulation of a plugin. Ideally, these would
 * automatically generate themselves based on the plugin passed in.
 *
 * @author c
 * @since 5/27/15
 */
public abstract class PluginCommand implements Command {
    @Getter
    private final Plugin plugin;

    public PluginCommand(Plugin plugin) {
        this.plugin = plugin;
    }
}
