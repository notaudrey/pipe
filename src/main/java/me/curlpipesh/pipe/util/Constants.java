package me.curlpipesh.pipe.util;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author audrey
 * @since 4/30/15
 */
@SuppressWarnings("unused")
public class Constants {
    private static final List<ObfusClass> obfuscatedClasses = new CopyOnWriteArrayList<>();

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
            ENTITYRENDERER = "bfk",
            ENTITYLIVING = "ps",
            ENTITYCREATURE = "py",
            ENTITYAGEABLE = "ph",
            ENTITYANIMAL = "tm",
            ENTITYMONSTER = "vv";

    public static ObfusClass getByName(String name) {
        Optional<ObfusClass> o = obfuscatedClasses.stream().filter(c -> c.getRealName().equalsIgnoreCase(name))
                .findFirst();
        if(o.isPresent()) {
            return o.get();
        } else {
            throw new IllegalArgumentException("No such class found: " + name);
        }
    }

    static {
        obfuscatedClasses.add(new ObfusClass("Minecraft", MINECRAFT));
        obfuscatedClasses.add(new ObfusClass("GuiIngame", GUIINGAME));
        obfuscatedClasses.add(new ObfusClass("FontRenderer", FONTRENDERER));
        obfuscatedClasses.add(new ObfusClass("GameSettings", GAMESETTINGS));
        obfuscatedClasses.add(new ObfusClass("World", WORLD));
        obfuscatedClasses.add(new ObfusClass("AbstractWorld", ABSTRACTWORLD));
        obfuscatedClasses.add(new ObfusClass("WorldProvider", WORLDPROVIDER));
        obfuscatedClasses.add(new ObfusClass("Entity", ENTITY));
        obfuscatedClasses.add(new ObfusClass("EntityThePlayer", ENTITYTHEPLAYER));
        obfuscatedClasses.add(new ObfusClass("ScaledResolution", SCALEDRESOLUTION));
        obfuscatedClasses.add(new ObfusClass("EntityRenderer", ENTITYRENDERER));
        obfuscatedClasses.add(new ObfusClass("EntityLiving", ENTITYLIVING));
        obfuscatedClasses.add(new ObfusClass("EntityCreature", ENTITYCREATURE));
        obfuscatedClasses.add(new ObfusClass("EntityAgeable", ENTITYAGEABLE));
        obfuscatedClasses.add(new ObfusClass("EntityMonster", ENTITYMONSTER));
    }
}
