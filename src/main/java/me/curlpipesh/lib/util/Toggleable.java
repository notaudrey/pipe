package me.curlpipesh.lib.util;

/**
 * @author audrey
 * @since 5/14/15
 */
public interface Toggleable extends Enableable {
    default void toggle() {
        setEnabled(!isEnabled());
        if(isEnabled()) {
            onEnable();
        } else {
            onDisable();
        }
    }

    void onEnable();

    void onDisable();
}
