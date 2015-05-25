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
    private static final List<ObfusClass> obfuscatedClasses = new CopyOnWriteArrayList<>();

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
     * Name of the C0EPacketWindowClick class
     */
            C0EPACKETWINDOWCLICK = "ik",
    /**
     * Name of the NetHandlerPlayClient class
     */
            NETHANDLERPLAYCLIENT = "bcy",
    /**
     * Name of the Item class
     */
            ITEM = "zw";

    /**
     * Gets an {@link ObfusClass} representation of a class based on a non-obfuscated name
     *
     * @param name Non-obfuscated class name
     * @return <tt>ObfusClass</tt> representation of the obfuscated class
     */
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
        obfuscatedClasses.add(new ObfusClass("EntityAnimal", ENTITYANIMAL));
        obfuscatedClasses.add(new ObfusClass("EntityMonster", ENTITYMONSTER));
        obfuscatedClasses.add(new ObfusClass("BlockEntity", BLOCKENTITY));
        obfuscatedClasses.add(new ObfusClass("BlockEntityChest", BLOCKENTITYCHEST));
        obfuscatedClasses.add(new ObfusClass("BlockEntityEnderChest", BLOCKENTITYENDERCHEST));
        obfuscatedClasses.add(new ObfusClass("BlockPos", BLOCKPOS));
        obfuscatedClasses.add(new ObfusClass("Vec3i", VEC3I));
        obfuscatedClasses.add(new ObfusClass("Gui", GUI));
        obfuscatedClasses.add(new ObfusClass("GuiScreen", GUISCREEN));
        obfuscatedClasses.add(new ObfusClass("GuiMainMenu", GUIMAINMENU));
        obfuscatedClasses.add(new ObfusClass("IChatComponent", ICHATCOMPONENT));
        obfuscatedClasses.add(new ObfusClass("ChatComponentStyle", CHATCOMPONENTSTYLE));
        obfuscatedClasses.add(new ObfusClass("ChatComponentText", CHATCOMPONENTTEXT));
        obfuscatedClasses.add(new ObfusClass("IInventory", IINVENTORY));
        obfuscatedClasses.add(new ObfusClass("InventoryPlayer", INVENTORYPLAYER));
        obfuscatedClasses.add(new ObfusClass("ItemStack", ITEMSTACK));
        obfuscatedClasses.add(new ObfusClass("Container", CONTAINER));
        obfuscatedClasses.add(new ObfusClass("ContainerPlayer", CONTAINERPLAYER));
        obfuscatedClasses.add(new ObfusClass("EntityPlayer", ENTITYPLAYER));
        obfuscatedClasses.add(new ObfusClass("Slot", SLOT));
        obfuscatedClasses.add(new ObfusClass("NetworkManager", NETWORKMANAGER));
        obfuscatedClasses.add(new ObfusClass("Packet", PACKET));
        obfuscatedClasses.add(new ObfusClass("C0EPacketWindowClick", C0EPACKETWINDOWCLICK));
        obfuscatedClasses.add(new ObfusClass("NetHandlerPlayClient", NETHANDLERPLAYCLIENT));
        obfuscatedClasses.add(new ObfusClass("Item", ITEM));
    }
}
