package me.curlpipesh.pipe.util;

import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.gui.GuiScreen;

import java.util.List;

/**
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

    public static int getStringWidth(String string) {
        return 0;
    }

    public static void drawString(String string, float x, float y, int color, boolean shadow) {}

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

    public static boolean isEntityLiving(Object entity) {
        return false;
    }

    public static boolean isEntityAnimal(Object entity) {
        return false;
    }

    public static boolean isEntityMonster(Object entity) {
        return false;
    }

    public static List<?> getLoadedBlockEntities() {
        return null;
    }

    public static Vec3 getBlockEntityVec(Object blockEntity) {
        return null;
    }

    public static boolean isBlockEntityChest(Object blockEntity) {
        return false;
    }

    public static void enableLightmap() {}

    public static void disableLightmap() {}

    public static void addChatMessage(String message) {}

    public static void sendChatMessage(String message) {}

    public static Object getInventoryContainer() {
        return null;
    }

    public static Object inventoryClick(int slot, int button, int mode, Object player) {
        return null;
    }

    public static Object getStackInSlot(Object player, int slot) {
        return null;
    }

    public static Object inventoryClickPacket(int window, int slot, int button, int mode, Object stack, short actionNumber) {
        return null;
    }

    public static void sendPacket(Object packet) {}

    public static void transmuteStack(Object stack, String itemId) {}

    public static int getWidth() {
        return 0;
    }

    public static int getHeight() {
        return 0;
    }

    public static void displayGuiScreen(GuiScreen gui) {}

    public static void displayGuiModule(GuiModule module) {}
}
