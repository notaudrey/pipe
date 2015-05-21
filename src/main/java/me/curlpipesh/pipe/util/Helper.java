package me.curlpipesh.pipe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.util.Constants;

/**
 * @author audrey
 * @since 5/2/15
 */
public class Helper {
    public static boolean isWorldNull() {
        return getWorld() == null;
    }

    public static Object getThing() {
        return Pipe.getInstance();
    }

    public static Object getMinecraft() {
        try {
            getThing();
            return Constants.GETMINECRAFT.invoke(null);
        } catch(IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getPlayer() {
        if(!isWorldNull()) {
            try {
                return Constants.MINECRAFTCLASS.getDeclaredField("h").get(getMinecraft());
            } catch(IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException(new IllegalAccessException("Why are you trying to use getPlayer()? world==null!"));
        }
    }

    public static Object getGameSettings() {
        try {
            return Constants.GAMESETTINGSFIELD.get(getMinecraft());
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isIngameGuiInDebugMode() {
        try {
            return (boolean) Constants.DEBUGMODEFIELD.get(getGameSettings());
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getFontRenderer() {
        try {
            return Constants.FONTRENDERERFIELD.get(getMinecraft());
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getFontHeight() {
        try {
            return (Integer) Constants.FONTHEIGHTFIELD.get(getFontRenderer());
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getStringWidth(String e) {
        try {
            return (Integer) Constants.GETSTRINGWIDTH.invoke(getFontRenderer(), e);
        } catch(IllegalAccessException | InvocationTargetException e1) {
            throw new RuntimeException(e1);
        }
    }

    public static Object getWorld() {
        try {
            return Constants.WORLDFIELD.get(getMinecraft());
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getNewScaledResolution() {
        try {
            return Constants.SCALEDRESOLUTIONCONSTRUCTOR.newInstance(getMinecraft());
        } catch(InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static double getScaledResolutionHeight(Object scaledResolution) {
        try {
            Field f = Constants.SCALEDRESOLUTIONCLASS.cast(scaledResolution).getClass().getDeclaredField("b");
            f.setAccessible(true);
            return (Double) f.get(scaledResolution);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getScaledResolutionScaleFactor(Object scaledResolution) {
        try {
            Field f = Constants.SCALEDRESOLUTIONCLASS.cast(scaledResolution).getClass().getDeclaredField("e");
            f.setAccessible(true);
            return (Integer) f.get(scaledResolution);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<?> getLoadedEntities() {
        try {
            return (List<?>) Constants.LOADEDENTITIESLISTFIELD.get(getWorld());
        } catch(IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static float[] getLightBrightnessTable() {
        Constants.LIGHTBRIGHTNESSTABLEFIELD.setAccessible(true);
        try {
            return (float[])Constants.LIGHTBRIGHTNESSTABLEFIELD.get(Constants.WORLDPROVIDERFIELD.get(getWorld()));
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
