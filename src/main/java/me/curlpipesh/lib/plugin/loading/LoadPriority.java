package me.curlpipesh.lib.plugin.loading;

/**
 * Signifies how a plugin is supposed to be loaded, be it before all other
 * plugins, after all other plugins, or before or after a specific plugin.
 *
 * @author c
 * @since 5/27/15
 */
public enum LoadPriority {
    /**
     * Specifies that a plugin must be loaded before anything else.
     */
    BEFORE_ALL,

    /**
     * Specifies that a plugin must be loaded after everything else
     */
    AFTER_ALL,

    /**
     * Specifies that a plugin may be loaded whenever, but must be initialized
     * before everything else
     */
    INIT_BEFORE_ALL,

    /**
     * Specifies that a plugin may be loaded whenever, but must be initialized
     * after everything else
     */
    INIT_AFTER_ALL,

    /**
     * Specifies that nothing special needs to be done with this plugin's load
     * or initialization order
     */
    NONE
}
