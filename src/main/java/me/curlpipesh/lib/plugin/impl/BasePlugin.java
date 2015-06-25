package me.curlpipesh.lib.plugin.impl;

import lombok.Getter;
import lombok.Setter;
import me.curlpipesh.lib.config.BasicConfigurable;
import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.util.Keybind;
import me.curlpipesh.lib.util.Keyed;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.lib.util.Toggleable;
import me.curlpipesh.pipe.event.Keypress;
import me.curlpipesh.pipe.util.helpers.KeypressHelper;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * Base plugin class that allows for toggling on and off
 *
 * @author c
 * @since 5/9/15
 */
public abstract class BasePlugin extends BasicConfigurable implements Plugin, Keyed, Toggleable {
    @Getter
    @Setter
    private boolean enabled = false;

    @Getter
    @Setter
    private String status = Status.OK;

    @Getter
    @Setter
    private String name;

    private final Keybind keybind = new Keybind(-1);

    public BasePlugin() {
        EventManager.register(new Listener<Keypress>() {
            @Override
            public void event(Keypress keypress) {
                if(KeypressHelper.isKeyPlusModifiersDown(keybind, keypress)) {
                    boolean prevState = isEnabled();
                    try {
                        toggle();
                        setStatus(Status.OK);
                    } catch(Exception e) {
                        if(prevState) {
                            setStatus(Status.DISABLE_ERROR);
                        } else {
                            setStatus(Status.ENABLE_ERROR);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public int getKey() {
        return keybind.getKey();
    }

    @Override
    public void setKey(int key) {
        keybind.setKey(key);
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
    public Integer[] getModifiers() {
        return keybind.getModifiers();
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }
}
