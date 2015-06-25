package me.curlpipesh.pipe.util.helpers;

import org.lwjgl.Sys;

/**
 * Simpler helper class to help with timing things, using LWJGL's {@link Sys}
 * class' timer.
 *
 * @author c
 * @since 5/24/15
 */
public class TimeHelper {
    /**
     * Returns the current time, in milliseconds
     *
     * @return The current time, in milliseconds
     */
    public static long getTimeMillis() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
