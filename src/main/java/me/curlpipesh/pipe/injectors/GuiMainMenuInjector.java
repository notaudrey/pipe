package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Iterator;
import java.util.List;

/**
 * @author audrey
 * @since 5/23/15
 */
@Inject(Constants.GUIMAINMENU)
public class GuiMainMenuInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        for(MethodNode m : (List<MethodNode>)classNode.methods) {
            if(m.name.equals("a") && m.desc.equals("(IIF)V")) {
                Iterator<AbstractInsnNode> i = m.instructions.iterator();
                while(i.hasNext()) {
                    AbstractInsnNode insn = i.next();
                    if(insn instanceof LdcInsnNode) {
                        LdcInsnNode ldc = (LdcInsnNode) insn;
                        if(ldc.cst instanceof String) {
                            String cst = (String) ldc.cst;
                            if(cst.contains("Minecraft")) {
                                cst += " (Pipe v§a" + Pipe.getVersion() + "§r)";
                            }
                            ldc.cst = cst;
                        }
                    }
                }
            }
        }
    }
}
