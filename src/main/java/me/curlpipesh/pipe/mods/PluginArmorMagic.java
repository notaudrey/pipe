package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.annotations.Disabled;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * Attempts to place an invalid item in the helmet armor slot. Probably not
 * possible because inventory is handled by the server, not the client.
 *
 * @author audrey
 * @since 5/23/15
 */
@Disabled
public class PluginArmorMagic extends ExecutablePlugin {
    @Override
    public void init() {
        setName("Armor Magic");
        setKey(Keyboard.KEY_A);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void execute() {
        int itemSlot = 36;
        int armorSlot = 5;
        Object stack = Helper.getStackInSlot(Helper.getPlayer(), itemSlot);
        Helper.transmuteStack(stack, "minecraft:diamond_helmet");
        Helper.inventoryClick(itemSlot, 0, 0, Helper.getPlayer());
        Helper.inventoryClickPacket(0, itemSlot, 0, 0, stack, (short)0);
        Helper.inventoryClick(armorSlot, 0, 0, Helper.getPlayer());
        Helper.inventoryClickPacket(0, armorSlot, 0, 0, stack, (short)0);
    }
}
