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

    @SuppressWarnings("SpellCheckingInspection")
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
            ENTITYMONSTER = "vv",
            BLOCKENTITY = "akw",
            BLOCKENTITYCHEST = "aky",
            BLOCKENTITYENDERCHEST = "alf",
            BLOCKPOS = "cj",
            VEC3I = "df",
            GUI = "avp",
            GUISCREEN = "axu",
            GUIMAINMENU = "aya",
            ICHATCOMPONENT = "eu",
            CHATCOMPONENTSTYLE = "es",
            CHATCOMPONENTTEXT = "fa",
            INVENTORYPLAYER = "wm",
            IINVENTORY = "og",
            ITEMSTACK = "zx",
            CONTAINER = "xi",
            CONTAINERPLAYER = "xy",
            ENTITYPLAYER = "wn",
            SLOT = "yg",
            NETWORKMANAGER = "ek",
            PACKET = "ff",
            C0EPACKETWINDOWCLICK = "ik",
            NETHANDLERPLAYCLIENT = "bcy";

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
    }
}
