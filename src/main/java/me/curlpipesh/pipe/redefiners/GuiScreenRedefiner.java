package me.curlpipesh.pipe.redefiners;

import me.curlpipesh.bytecodetools.redefine.Redefiner;
import me.curlpipesh.pipe.generators.GuiScreenGenerator;
import me.curlpipesh.pipe.gui.GuiScreen;

import java.lang.instrument.ClassDefinition;

/**
 * @author audrey
 * @since 5/24/15
 */
public class GuiScreenRedefiner implements Redefiner {
    @Override
    public ClassDefinition redefine() {
        return new ClassDefinition(GuiScreen.class, GuiScreenGenerator.generate());
    }
}
