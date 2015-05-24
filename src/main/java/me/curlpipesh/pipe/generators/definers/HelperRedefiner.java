package me.curlpipesh.pipe.generators.definers;

import me.curlpipesh.bytecodetools.define.Redefiner;
import me.curlpipesh.pipe.generators.HelperGenerator;
import me.curlpipesh.pipe.util.Helper;

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
