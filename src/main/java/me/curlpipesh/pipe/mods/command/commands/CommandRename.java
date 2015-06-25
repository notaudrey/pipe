package me.curlpipesh.pipe.mods.command.commands;

import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.commands.Command;
import me.curlpipesh.pipe.util.helpers.Helper;

import java.util.List;

/**
 * @author c
 * @since 6/25/15
 */
public class CommandRename implements Command {
    @Override
    public boolean run(String command, String[] args) {
        if(args.length != 1) {
            return false;
        }
        Pipe.log("currentSlot: " + Helper.getCurrentSlot(), "adjusted: " + (36 - Helper.getCurrentSlot()));
        Helper.setItemStackDisplayName(Helper.getStackInSlot(Helper.getPlayer(), 36 - Helper.getCurrentSlot()), args[0]);
        return true;
    }

    @Override
    public String getName() {
        return "Rename";
    }

    @Override
    public String getDescription() {
        return "Renames an ItemStack";
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
}
