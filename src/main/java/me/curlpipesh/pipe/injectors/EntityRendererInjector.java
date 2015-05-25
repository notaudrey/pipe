package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

import java.util.Iterator;
import java.util.List;

import static org.objectweb.asm.Opcodes.*;

/**
 * Adds the {@link me.curlpipesh.pipe.event.Render3D} event firing.
 *
 * @author c
 * @since 5/21/15
 */
@Inject(Constants.ENTITYRENDERER)
public class EntityRendererInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        ((List<MethodNode>) classNode.methods).stream().filter(m -> m.name.equals("a") && m.desc.equals("(IFJ)V")).forEach(m -> {
            InsnList list = new InsnList();
            list.add(new FieldInsnNode(GETSTATIC, "me/curlpipesh/pipe/event/Render3D", "instance", "Lme/curlpipesh/pipe/event/Render3D;"));
            list.add(new MethodInsnNode(INVOKESTATIC, "pw/aria/event/EventManager", "push", "(Ljava/lang/Object;)Ljava/lang/Object;", false));
            list.add(new InsnNode(POP));
            Iterator<AbstractInsnNode> i = m.instructions.iterator();
            AbstractInsnNode injectInsn = null;
            while(i.hasNext()) {
                AbstractInsnNode insn = i.next();
                if(insn instanceof LdcInsnNode) {
                    LdcInsnNode linsn = (LdcInsnNode) insn;
                    if(linsn.cst.equals("hand")) {
                        injectInsn = insn.getPrevious().getPrevious().getPrevious();
                    }
                }
            }

            if(injectInsn == null) {
                Pipe.log("[bfk] Instruction was null?!");
                throw new IllegalStateException("Instruction was null?!");
            }
            m.instructions.insertBefore(injectInsn, list);
        });
    }
}
