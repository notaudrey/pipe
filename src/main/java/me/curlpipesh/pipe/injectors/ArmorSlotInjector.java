package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author audrey
 * @since 5/23/15
 */
@Inject(Constants.CONTAINERPLAYER + "$1")
public class ArmorSlotInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        ((List<MethodNode>) classNode.methods).stream()
                .filter(m -> m.name.equals("a") && m.desc.equals("(" + Constants.getByName("ItemStack").getDesc() + ")Z"))
                .forEach(m -> {
            m.instructions.clear();
            m.instructions.add(new InsnNode(ICONST_1));
            m.instructions.add(new InsnNode(IRETURN));
        });
    }
}
