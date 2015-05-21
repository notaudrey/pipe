package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

import java.util.Iterator;
import java.util.List;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @author audrey
 * @since 5/21/15
 */
@Inject(Constants.ENTITYRENDERER)
public class EntityRendererInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        ((List<MethodNode>) classNode.methods).stream().filter(m -> m.name.equals("a") && m.desc.equals("(FI)V")).forEach(m -> {
            InsnList list = new InsnList();
            list.add(new FieldInsnNode(GETSTATIC, "me/curlpipesh/pipe/event/Render3D", "instance", "Lme/curlpipesh/pipe/event/Render3D;"));
            list.add(new MethodInsnNode(INVOKESTATIC, "pw/aria/event/EventManager", "push", "(Ljava/lang/Object;)Ljava/lang/Object;", false));
            Iterator<AbstractInsnNode> i = m.instructions.iterator();
            AbstractInsnNode injectInsn = null;
            while(i.hasNext()) {
                AbstractInsnNode insn = i.next();
                if(insn instanceof MethodInsnNode) {
                    MethodInsnNode minsn = (MethodInsnNode) insn;
                    if(minsn.owner.equals("org/lwjgl/util/glu/Project")) {
                        injectInsn = insn;
                        break;
                    }
                }
            }

            if(injectInsn == null) {
                Pipe.log("[bfk] Instruction was null?!");
                throw new IllegalStateException("Instruction was null?!");
            }
            m.instructions.insertBefore(injectInsn.getNext(), list);
        });
    }
}
