package me.curlpipesh.lib.plugin.impl;

import lombok.Getter;
import lombok.Setter;
import me.curlpipesh.lib.config.BasicConfigurable;
import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.util.Keybind;
import me.curlpipesh.lib.util.Keyed;
import me.curlpipesh.pipe.event.Keypress;
import me.curlpipesh.pipe.util.KeypressHelper;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * @author audrey
 * @since 5/24/15
 */
public abstract class ExecutablePlugin extends BasicConfigurable implements Plugin, Keyed {
    @Getter
    @Setter
    private String status = "§eOk";

    @Getter
    @Setter
    private String name;

    private final Keybind keybind = new Keybind(-1);

    public ExecutablePlugin() {
        EventManager.register(new Listener<Keypress>() {
            @Override
            public void event(Keypress keypress) {
                if(KeypressHelper.isKeyPlusModifiersDown(keybind, keypress)) {
                    execute();
                }
            }
        });
    }

    public abstract void execute();

    @Override
    public int getKey() {
        return keybind.getKey();
    }

    @Override
    public void setKey(int key) {
        keybind.setKey(key);
    }

    @Override
    public Integer[] getModifiers() {
        return new Integer[0];
    }

    @Override
    public void addModifier(int mod) {
        keybind.addModifier(mod);
    }

    @Override
    public void removeModifier(int mod) {
        keybind.removeModifier(mod);
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }
}
