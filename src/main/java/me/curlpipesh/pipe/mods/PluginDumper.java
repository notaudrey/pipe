package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * @author audrey
 * @since 5/23/15
 */
public class PluginDumper extends BasePlugin {
    @Override
    public void init() {
        setName("Dumper");
        setKey(Keyboard.KEY_D);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }

    @Override
    public void onEnable() {
        Helper.addChatMessage("§aSo §cwe §ecan §4send §8chat §dmessages §7§l§n§mnow§r!");
        toggle();
    }
}
