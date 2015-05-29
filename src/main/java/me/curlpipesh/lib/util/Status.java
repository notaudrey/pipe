package me.curlpipesh.lib.util;

/**
 * Generic status codes for {@link Statused}
 *
 * @author c
 * @since 5/21/15
 */
public interface Status {
    /**
     * Everything is fine
     */
    String OK = "§eOk";

    /**
     * Error on enable. For {@link Enableable} and {@link Toggleable}.
     */
    String ENABLE_ERROR = "§cEnable error";

    /**
     * Error on disable. For {@link Enableable} and {@link Toggleable}.
     */
    String DISABLE_ERROR = "§cDisable error";

    /**
     * Error while rendering.
     */
    String RENDER_ERROR = "§cRender error";

    /**
     * Nothing is rendering
     */
    String NOT_RENDERING = "§cNot rendering";

    /**
     * Error loading configuration
     */
    String LOAD_ERROR = "§cLoad error";

    /**
     * Error saving configuration
     */
    String SAVE_ERROR = "§cSave error";

    /**
     * Generic error
     */
    String GENERIC_ERROR = "§cError";

    /**
     * When nothing else works.
     */
    String INTERNAL_ERROR = "§cInternal error";
}
