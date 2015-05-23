package me.curlpipesh.pipe.config.option;

import me.curlpipesh.lib.util.Toggleable;

/**
 * @author audrey
 * @since 5/23/15
 */
public class ToggleOption extends BooleanOption implements Toggleable {
    public ToggleOption(String name, Boolean defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}

    @Override
    public boolean isEnabled() {
        return get();
    }

    @Override
    public void setEnabled(boolean e) {
        set(e);
    }
}
