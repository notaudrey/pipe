package me.curlpipesh.lib.util;

/**
 * @author audrey
 * @since 5/14/15
 */
public interface Keyed {
    int getKey();

    void setKey(int key);

    Integer[] getModifiers();

    void addModifier(int mod);

    void removeModifier(int mod);
}
