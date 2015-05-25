package me.curlpipesh.lib.util;

/**
 * An object that has a key binding
 *
 * @author c
 * @since 5/14/15
 */
public interface Keyed {
    /**
     * Returns the main key that this object is bound to
     *
     * @return The main key that this object is bound to
     */
    int getKey();

    /**
     * Sets the main key that this object is bound to
     *
     * @param key The new main key to bind to
     */
    void setKey(int key);

    /**
     * Returns all the current modifier keys of this object's key binding
     *
     * @return An <tt>Integer[]</tt> of all the object's current modifier keys
     */
    Integer[] getModifiers();

    /**
     * Adds a modifier key
     *
     * @param mod The modifier key to add
     */
    void addModifier(int mod);

    /**
     * Removes a modifier key
     *
     * @param mod The modifier key to remove
     */
    void removeModifier(int mod);
}
