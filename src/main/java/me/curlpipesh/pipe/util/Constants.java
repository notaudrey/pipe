package me.curlpipesh.pipe.util;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Constants about the game. These will (most likely) change from version to
 * version.
 *
 * @author c
 * @since 4/30/15
 */
@SuppressWarnings("unused")
public class Constants {
    /**
     * Mappings of obfuscated classes to usable names
     */
    private static final List<ObfusClass> OBFUSCATED_CLASSES = new CopyOnWriteArrayList<>();

    @SuppressWarnings("SpellCheckingInspection")
    public static final String
            /**
             * Name of the Minecraft class
             */
            MINECRAFT = "ave",

            /**
             * Name of the GuiIngame class
             */
            GUIINGAME = "avo",

            /**
             * Name of the FontRenderer class
             */
            FONTRENDERER = "avn",

            /**
             * Name of the GameSettings class
             */
            GAMESETTINGS = "avh",

            /**
             * Name of the World class
             */
            WORLD = "bdb",

            /**
             * Name of the AbstractWorld class
             */
            ABSTRACTWORLD = "adm",

            /**
             * Name of the WorldProvider class
             */
            WORLDPROVIDER = "anm",

            /**
             * Name of the Entity class
             */
            ENTITY = "pk",

            /**
             * Name of the EntityClientPlayer class
             */
            ENTITYTHEPLAYER = "bew",

            /**
             * Name of the ScaledResolution class
             */
            SCALEDRESOLUTION = "avr",

            /**
             * Name of the EntityRenderer class
             */
            ENTITYRENDERER = "bfk",

            /**
             * Name of the EntityLiving class
             */
            ENTITYLIVING = "ps",

            /**
             * Name of the EntityCreature class
             */
            ENTITYCREATURE = "py",

            /**
             * Name of the EntityAgeable class
             */
            ENTITYAGEABLE = "ph",

            /**
             * Name of the EntityAnimal class
             */
            ENTITYANIMAL = "tm",

            /**
             * Name of the EntityMonster class
             */
            ENTITYMONSTER = "vv",

            /**
             * Name of the BlockEntity class (formerly TileEntity)
             */
            BLOCKENTITY = "akw",

            /**
             * Name of the BlockEntityChest class
             */
            BLOCKENTITYCHEST = "aky",

            /**
             * Name of the BlockEntityEnderChest class
             */
            BLOCKENTITYENDERCHEST = "alf",

            /**
             * Name of the BlockPos class
             */
            BLOCKPOS = "cj",

            /**
             * Name of the Vec3i class
             */
            VEC3I = "df",

            /**
             * Name of the Gui class
             */
            GUI = "avp",

            /**
             * Name of the GuiScreen class
             */
            GUISCREEN = "axu",

            /**
             * Name of the GuiMainMenu class
             */
            GUIMAINMENU = "aya",

            /**
             * Name of the IChatComponent class
             */
            ICHATCOMPONENT = "eu",

            /**
             * Name of the ChatComponentStyle class
             */
            CHATCOMPONENTSTYLE = "es",

            /**
             * Name of the ChatComponentText class
             */
            CHATCOMPONENTTEXT = "fa",

            /**
             * Name of the InventoryPlayer class
             */
            INVENTORYPLAYER = "wm",

            /**
             * Name of the IInventory class
             */
            IINVENTORY = "og",

            /**
             * Name of the ItemStack class
             */
            ITEMSTACK = "zx",

            /**
             * Name of the Container class. Used for some inventory stuff
             */
            CONTAINER = "xi",

            /**
             * Name of the ContainerPlayer class
             */
            CONTAINERPLAYER = "xy",

            /**
             * Name of the EntityPlayer class
             */
            ENTITYPLAYER = "wn",

            /**
             * Name of the Slot class. Used for some inventory stuff
             */
            SLOT = "yg",

            /**
             * Name of the NetworkManager class
             */
            NETWORKMANAGER = "ek",

            /**
             * Name of the Packet class
             */
            PACKET = "ff",

            /**
             * Name of the PacketClientWindowClick class
             */
            PACKETWINDOWCLICK_CLIENT = "ik",

            /**
             * Name of the NetHandlerPlayClient class
             */
            NETHANDLERPLAYCLIENT = "bcy",

            /**
             * Name of the Item class
             */
            ITEM = "zw",

            /**
             * Name of the PacketClientChatMessage class
             */
            PACKETCHATMESSAGE_CLIENT = "ie";

    /**
     * Gets an {@link ObfusClass} representation of a class based on a non-obfuscated name
     *
     * @param name Non-obfuscated class name
     * @return <tt>ObfusClass</tt> representation of the obfuscated class
     */
    public static ObfusClass getByName(String name) {
        Optional<ObfusClass> o = OBFUSCATED_CLASSES.stream().filter(c -> c.getRealName().equalsIgnoreCase(name))
                .findFirst();
        if(o.isPresent()) {
            return o.get();
        } else {
            throw new IllegalArgumentException("No such class found: " + name);
        }
    }

    static {
        OBFUSCATED_CLASSES.add(new ObfusClass("Minecraft", MINECRAFT));
        OBFUSCATED_CLASSES.add(new ObfusClass("GuiIngame", GUIINGAME));
        OBFUSCATED_CLASSES.add(new ObfusClass("FontRenderer", FONTRENDERER));
        OBFUSCATED_CLASSES.add(new ObfusClass("GameSettings", GAMESETTINGS));
        OBFUSCATED_CLASSES.add(new ObfusClass("World", WORLD));
        OBFUSCATED_CLASSES.add(new ObfusClass("AbstractWorld", ABSTRACTWORLD));
        OBFUSCATED_CLASSES.add(new ObfusClass("WorldProvider", WORLDPROVIDER));
        OBFUSCATED_CLASSES.add(new ObfusClass("Entity", ENTITY));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityThePlayer", ENTITYTHEPLAYER));
        OBFUSCATED_CLASSES.add(new ObfusClass("ScaledResolution", SCALEDRESOLUTION));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityRenderer", ENTITYRENDERER));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityLiving", ENTITYLIVING));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityCreature", ENTITYCREATURE));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityAgeable", ENTITYAGEABLE));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityAnimal", ENTITYANIMAL));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityMonster", ENTITYMONSTER));
        OBFUSCATED_CLASSES.add(new ObfusClass("BlockEntity", BLOCKENTITY));
        OBFUSCATED_CLASSES.add(new ObfusClass("BlockEntityChest", BLOCKENTITYCHEST));
        OBFUSCATED_CLASSES.add(new ObfusClass("BlockEntityEnderChest", BLOCKENTITYENDERCHEST));
        OBFUSCATED_CLASSES.add(new ObfusClass("BlockPos", BLOCKPOS));
        OBFUSCATED_CLASSES.add(new ObfusClass("Vec3i", VEC3I));
        OBFUSCATED_CLASSES.add(new ObfusClass("Gui", GUI));
        OBFUSCATED_CLASSES.add(new ObfusClass("GuiScreen", GUISCREEN));
        OBFUSCATED_CLASSES.add(new ObfusClass("GuiMainMenu", GUIMAINMENU));
        OBFUSCATED_CLASSES.add(new ObfusClass("IChatComponent", ICHATCOMPONENT));
        OBFUSCATED_CLASSES.add(new ObfusClass("ChatComponentStyle", CHATCOMPONENTSTYLE));
        OBFUSCATED_CLASSES.add(new ObfusClass("ChatComponentText", CHATCOMPONENTTEXT));
        OBFUSCATED_CLASSES.add(new ObfusClass("IInventory", IINVENTORY));
        OBFUSCATED_CLASSES.add(new ObfusClass("InventoryPlayer", INVENTORYPLAYER));
        OBFUSCATED_CLASSES.add(new ObfusClass("ItemStack", ITEMSTACK));
        OBFUSCATED_CLASSES.add(new ObfusClass("Container", CONTAINER));
        OBFUSCATED_CLASSES.add(new ObfusClass("ContainerPlayer", CONTAINERPLAYER));
        OBFUSCATED_CLASSES.add(new ObfusClass("EntityPlayer", ENTITYPLAYER));
        OBFUSCATED_CLASSES.add(new ObfusClass("Slot", SLOT));
        OBFUSCATED_CLASSES.add(new ObfusClass("NetworkManager", NETWORKMANAGER));
        OBFUSCATED_CLASSES.add(new ObfusClass("Packet", PACKET));
        OBFUSCATED_CLASSES.add(new ObfusClass("PacketClientWindowClick", PACKETWINDOWCLICK_CLIENT));
        OBFUSCATED_CLASSES.add(new ObfusClass("NetHandlerPlayClient", NETHANDLERPLAYCLIENT));
        OBFUSCATED_CLASSES.add(new ObfusClass("Item", ITEM));
        OBFUSCATED_CLASSES.add(new ObfusClass("PacketClientChatMessage", PACKETCHATMESSAGE_CLIENT));
    }
}
