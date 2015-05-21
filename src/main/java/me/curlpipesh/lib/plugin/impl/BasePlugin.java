package me.curlpipesh.lib.plugin.impl;

import lombok.Getter;
import lombok.Setter;
import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.util.Keyed;
import me.curlpipesh.lib.util.Statused;
import me.curlpipesh.lib.util.Toggleable;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.event.Keypress;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * @author audrey
 * @since 5/9/15
 */
public abstract class BasePlugin implements Plugin, Keyed, Toggleable {
    @Getter
    @Setter
    private boolean enabled = false;

    @Getter
    @Setter
    private String status = "§eOk";

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int key;

    public BasePlugin() {
        EventManager.register(new Listener<Keypress>() {
            @Override
            public void event(Keypress keypress) {
                if(keypress.getKey() == getKey()) {
                    toggle();
                }
            }
        });
    }

    @Override
    public void load() {
        Pipe.log("Configuration is not yet implemented!");
    }

    @Override
    public void save() {
        Pipe.log("Configuration is not yet implemented!");
    }
}
