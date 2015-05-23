package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author audrey
 * @since 5/23/15
 */
@Inject(Constants.BLOCKENTITY)
public class BlockEntityInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        ((List<FieldNode>) classNode.fields).stream().filter(f -> f.name.equals("c"))
                .forEach(f -> f.access = ACC_PUBLIC);
    }
}
