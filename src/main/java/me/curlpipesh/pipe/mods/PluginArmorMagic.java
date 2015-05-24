package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * @author audrey
 * @since 5/23/15
 */
public class PluginArmorMagic extends ExecutablePlugin {
    @Override
    public void init() {
        setName("Armor hake");
        setKey(Keyboard.KEY_A);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    @Override
    protected void execute() {
        int itemSlot = 36;
        int armorSlot = 8;
        Object stack = Helper.inventoryClick(itemSlot, 0, 0, Helper.getPlayer());
        Helper.inventoryClickPacket(0, itemSlot, 0, 0, stack, (short)0);
        Helper.inventoryClick(armorSlot, 0, 0, Helper.getPlayer());
        Helper.inventoryClickPacket(0, armorSlot, 0, 0, stack, (short)0);
    }
}
