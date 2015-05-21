package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.pipe.event.Tick;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * @author audrey
 * @since 5/9/15
 */
public class PluginBrightness extends BasePlugin {
    private float[] lightBrightnessTableBackup = new float[16];

    @Override
    public void init() {
        setKey(Keyboard.KEY_F);
        setName("Brightness");
        EventManager.register(new Listener<Tick>() {
            @Override
            public void event(Tick tick) {
                if(PluginBrightness.this.isEnabled()) {
                    if(!Helper.isWorldNull()) {
                        for(int i = 0; i < 16; i++) {
                            Helper.getLightBrightnessTable()[i] = 1.0F;
                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean isStatusShown() {
        return true;
    }

    @Override
    public void onEnable() {
        System.arraycopy(Helper.getLightBrightnessTable(), 0, lightBrightnessTableBackup, 0, lightBrightnessTableBackup.length);
    }

    @Override
    public void onDisable() {
        for(int i = 0; i < 16; i++) {
            Helper.getLightBrightnessTable()[i] = lightBrightnessTableBackup[i];
        }
    }
}
