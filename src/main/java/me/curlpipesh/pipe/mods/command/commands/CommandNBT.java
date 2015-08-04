package me.curlpipesh.pipe.mods.command.commands;

import me.curlpipesh.pipe.commands.Command;
import me.curlpipesh.pipe.util.helpers.ChatHelper;
import me.curlpipesh.pipe.util.helpers.Helper;

import java.util.List;

/**
 * @author c
 * @since 6/25/15
 */
@SuppressWarnings("unused")
public class CommandNBT implements Command {
    @Override
    public boolean run(String command, String[] args) {
        if(args.length == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(String e : args) {
            sb.append(e).append(" ");
        }
        ChatHelper.log("Currently holding: " + Helper.getStackInSlot(Helper.getPlayer(), Helper.getCurrentSlot() + 36),
                "Which is in slot '" + (Helper.getCurrentSlot() + 36) + "', relative slot '" + Helper.getCurrentSlot() + "'.");
        Helper.applyJsonNbtToCurrentItem(sb.toString().trim());
        return true;
    }

    @Override
    public String getName() {
        return "NBT";
    }

    @Override
    public String getDescription() {
        return "Applies NBT tags to the currently held item. Valid NBT data is written in " +
                "JSON format (as according to normal Minecraft standards), and will be validated " +
                "by the game.";
    }

    @Override
    public List<Command> getSubcommands() {
        return null;
    }

    @Override
    public boolean takesRawInput() {
        return true;
    }

    @Override
    public void setRawInput(boolean e) {
    }

    @Override
    public boolean generateUsage() {
        return false;
    }

    @Override
    public String getUsage() {
        return "nbt <data...>";
    }
}
