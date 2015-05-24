package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * @author audrey
 * @since 5/23/15
 */
public class PluginArmorMagic extends BasePlugin {
    @Override
    public void init() {
        setName("Armor hake");
        setKey(Keyboard.KEY_A);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onEnable() {
        int itemSlot = 36;
        int armorSlot = 5;
        Object stack = Helper.getStackInSlot(Helper.getPlayer(), itemSlot);
        Helper.inventoryClick(itemSlot, 0, 0, Helper.getPlayer());
        //Helper.inventoryClickPacket(0, itemSlot, 0, 0, stack, (short)0);
        Helper.inventoryClick(armorSlot, 0, 0, Helper.getPlayer());
        //Helper.inventoryClickPacket(0, armorSlot, 0, 0, stack, (short)0);
        toggle();
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }
}
