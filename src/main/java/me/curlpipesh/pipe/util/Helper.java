package me.curlpipesh.pipe.util;

import java.util.List;

/**
 * This class must never ever ever ever be included in the final JAR. Its only
 * purpose is for "compatibility" so that we don't run into compile errors,
 * since the actual version of this class is generated at runtime by
 * {@link me.curlpipesh.pipe.util.HelperGenerator}.
 *
 * @author audrey
 * @since 5/2/15
 */
@SuppressWarnings("unused")
public class Helper {
    public static boolean isWorldNull() {
        return false;
    }

    public static Object getMinecraft() {
        return null;
    }

    public static Object getPlayer() {
        return null;
    }

    public static Object getGameSettings() {
        return null;
    }

    public static boolean isIngameGuiInDebugMode() {
        return false;
    }

    public static Object getFontRenderer() {
        return null;
    }

    public static int getFontHeight() {
        return 0;
    }

    public static int getStringWidth(String e) {
        return 0;
    }

    public static void drawString(String s, float x, float y, int color, boolean shadow) {}

    public static Object getWorld() {
        return null;
    }

    public static List<?> getLoadedEntities() {
        return null;
    }

    public static Vec3 getEntityVec(Object entity) {
        return null;
    }

    public static float[] getLightBrightnessTable() {
        return new float[] {};
    }
}
