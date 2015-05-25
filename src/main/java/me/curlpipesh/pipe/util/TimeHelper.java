package me.curlpipesh.pipe.util;

import org.lwjgl.Sys;

/**
 * @author audrey
 * @since 5/24/15
 */
public class TimeHelper {
    public static long getTimeMillis() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
