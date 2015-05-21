package me.curlpipesh.pipe.util;

/**
 * @author audrey
 * @since 4/30/15
 */
@SuppressWarnings("unused")
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
            SCALEDRESOLUTION = "avr",
            ENTITYRENDERER = "bfk";

    public static final Class<?> MINECRAFTCLASS;

    static {
        try {
            MINECRAFTCLASS = Class.forName(MINECRAFT);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
