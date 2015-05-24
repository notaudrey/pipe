package me.curlpipesh.pipe.redefiners;

import me.curlpipesh.bytecodetools.redefine.Redefiner;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.HelperGenerator;

import java.lang.instrument.ClassDefinition;

/**
 * @author audrey
 * @since 5/23/15
 */
public class HelperRedefiner implements Redefiner {
    @Override
    public ClassDefinition redefine() {
        return new ClassDefinition(Helper.class, HelperGenerator.generate());
    }
}
