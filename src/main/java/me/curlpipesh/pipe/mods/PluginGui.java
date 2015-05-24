package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * @author audrey
 * @since 5/24/15
 */
public class PluginGui extends ExecutablePlugin {
    @Override
    protected void execute() {
    }

    @Override
    public void init() {
        setName("Gui");
        setKey(Keyboard.KEY_Y);
    }
}
