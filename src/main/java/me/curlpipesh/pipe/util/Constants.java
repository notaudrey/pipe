package me.curlpipesh.pipe.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author audrey
 * @since 4/30/15
 */
public class Constants {
    public static final String
            MINECRAFT = "ave",
            GUIINGAME = "avo",
            FONTRENDERER = "avn",
            GAMESETTINGS = "avh",
            WORLD = "bdb",
            ABSTRACTWORLD = "adm",
            WORLDPROVIDER = "anm",
            ENTITY = "pk",
            ENTITYTHEPLAYER = "bew",
            SCALEDRESOLUTION = "avr";

    public static final Class<?> MINECRAFTCLASS, FONTRENDERERCLASS, GAMESETTINGSCLASS, WORLDCLASS, WORLDPROVIDERCLASS, ABSTRACTWORLDCLASS,
            ENTITYCLASS, ENTITYTHEPLAYERCLASS, SCALEDRESOLUTIONCLASS;

    public static final Method GETMINECRAFT, DRAWSTRING, GETSTRINGWIDTH;

    public static final Constructor<?> SCALEDRESOLUTIONCONSTRUCTOR;

    public static final Field FONTRENDERERFIELD, GAMESETTINGSFIELD, DEBUGMODEFIELD, WORLDFIELD, WORLDPROVIDERFIELD,
            LIGHTBRIGHTNESSTABLEFIELD, LOADEDENTITIESLISTFIELD, FONTHEIGHTFIELD;

    static {
        try {
            // Minecraft

            MINECRAFTCLASS = Class.forName(MINECRAFT);
            GETMINECRAFT = Arrays.stream(MINECRAFTCLASS.getDeclaredMethods()).filter(m -> m.getReturnType().equals(MINECRAFTCLASS))
                    .findFirst().get();
            Object minecraftInstance = GETMINECRAFT.invoke(null);

            // World, AbstractWorld, WorldProvider

            WORLDCLASS = Class.forName(WORLD);
            ABSTRACTWORLDCLASS = Class.forName(ABSTRACTWORLD);
            WORLDPROVIDERCLASS = Class.forName(WORLDPROVIDER);
            WORLDFIELD = Arrays.stream(MINECRAFTCLASS.getDeclaredFields())
                    .filter(f -> f.getType().getSimpleName().equals(WORLD)).findFirst().get();
            WORLDPROVIDERFIELD = Arrays.stream(ABSTRACTWORLDCLASS.getDeclaredFields())
                    .filter(f -> f.getType().equals(WORLDPROVIDERCLASS)).findFirst().get();
            LIGHTBRIGHTNESSTABLEFIELD = Arrays.stream(WORLDPROVIDERCLASS.getDeclaredFields())
                    .filter(f -> f.getType().equals(float[].class)).filter(f -> f.getName().equals("f"))
                    .findFirst().get();

            // Entity, Player
            ENTITYCLASS = Class.forName(ENTITY);
            LOADEDENTITIESLISTFIELD = Arrays.stream(ABSTRACTWORLDCLASS.getDeclaredFields())
                    .filter(f -> f.getName().equals("f")).findFirst().get();
            ENTITYTHEPLAYERCLASS = Class.forName(ENTITYTHEPLAYER);

            // FontRenderer

            FONTRENDERERFIELD = Arrays.stream(minecraftInstance.getClass().getDeclaredFields())
                    .filter(f -> f.getType().getSimpleName().equals(Constants.FONTRENDERER)).findFirst().get();
            FONTRENDERERCLASS = Class.forName(FONTRENDERERFIELD.getType().getName());
            FONTHEIGHTFIELD = FONTRENDERERFIELD.getType().getDeclaredField("a");
            // drawString(String, int, int, int, boolean);
            DRAWSTRING = FONTRENDERERFIELD.getType()
                    .getDeclaredMethod("a", String.class, float.class, float.class, int.class, boolean.class);
            // getStringWidth(String)
            GETSTRINGWIDTH = FONTRENDERERCLASS.getDeclaredMethod("a", String.class);

            // GameSettings

            GAMESETTINGSCLASS = Class.forName(GAMESETTINGS);
            GAMESETTINGSFIELD = Arrays.stream(MINECRAFTCLASS.getDeclaredFields())
                    .filter(f -> f.getType().getSimpleName().equals(GAMESETTINGS)).findFirst().get();
            DEBUGMODEFIELD = Arrays.stream(GAMESETTINGSCLASS.getDeclaredFields())
                    .filter(f -> f.getName().equals("aA")).findFirst().get();

            // ScaledResolution

            SCALEDRESOLUTIONCLASS = Class.forName(SCALEDRESOLUTION);
            SCALEDRESOLUTIONCONSTRUCTOR = SCALEDRESOLUTIONCLASS.getConstructor(MINECRAFTCLASS);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
