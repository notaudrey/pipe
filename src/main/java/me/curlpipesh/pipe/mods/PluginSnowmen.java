package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * Sends a happy message about snowmen to the in-game chat
 *
 * @author c
 * @since 5/23/15
 */
public class PluginSnowmen extends ExecutablePlugin {
    @Override
    public void init() {
        setName("Snowmen!");
        setKey(Keyboard.KEY_S);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    @Override
    public void execute() {
        Helper.addChatMessage("☃☃☃ ~Snowmen~ ☃☃☃");
    }
}
