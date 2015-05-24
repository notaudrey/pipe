package me.curlpipesh.pipe.util;

import me.curlpipesh.lib.util.Keybind;
import me.curlpipesh.pipe.event.Keypress;

import static org.lwjgl.input.Keyboard.*;

/**
 * @author audrey
 * @since 5/24/15
 */
public class KeypressHelper {
    public static boolean isKeyPlusModifiersDown(Keybind keybind, Keypress keypress) {
        if(keypress.getKey() == keybind.getKey()) {
            int mod = 0;
            for(int m : keybind.getModifiers()) {
                if(m == KEY_LCONTROL || m == KEY_RCONTROL) {
                    if(isKeyDown(KEY_LCONTROL) || isKeyDown(KEY_RCONTROL)) {
                        ++mod;
                    }
                } else if(m == KEY_LSHIFT || m == KEY_RSHIFT) {
                    if(isKeyDown(KEY_LSHIFT) || isKeyDown(KEY_RSHIFT)) {
                        ++mod;
                    }
                } else if(isKeyDown(m)) {
                    ++mod;
                }
            }
            return mod == keybind.getModifiers().length;
        }
        return false;
    }
}
