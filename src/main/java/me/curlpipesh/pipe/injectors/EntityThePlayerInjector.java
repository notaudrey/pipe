package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author c
 * @since 5/27/15
 */
@Inject(Constants.ENTITYTHEPLAYER)
public class EntityThePlayerInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        for(MethodNode m : (List<MethodNode>) classNode.methods) {
            if(m.name.equals("e") && m.desc.equals("(Ljava/lang/String;)V")) {
                InsnList list = new InsnList();
                list.add(new VarInsnNode(ALOAD, 1));
                list.add(new MethodInsnNode(INVOKESTATIC, "me/curlpipesh/pipe/util/ChatHelper", "handle", "(Ljava/lang/String;)V", false));
                list.add(new InsnNode(RETURN));
                m.instructions.clear();
                m.instructions.insert(list);
            }
        }
    }
}
