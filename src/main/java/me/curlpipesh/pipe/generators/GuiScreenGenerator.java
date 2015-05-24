package me.curlpipesh.pipe.generators;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import static me.curlpipesh.pipe.util.Constants.getByName;
import static org.objectweb.asm.Opcodes.*;

/**
 * @author audrey
 * @since 5/24/15
 */
public class GuiScreenGenerator {
    public static byte[] generate() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        FieldVisitor fv;
        MethodVisitor mv;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "me/curlpipesh/pipe/gui/GuiScreen", null, getByName("GuiScreen").getName(), null);
        cw.visitSource("GuiScreen.java", null);
        {
            fv = cw.visitField(ACC_PRIVATE, "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "instance", "Lme/curlpipesh/pipe/gui/GuiScreen;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, getByName("GuiScreen").getName(), "<init>", "()V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ACONST_NULL);
            mv.visitFieldInsn(PUTFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "initGui", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "init", "()V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "drawScreen", "(IIF)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "render", "(IIF)V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "mouseClicked", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "mouseDown", "(III)V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "mouseDownDrag", "(IIIJ)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(LLOAD, 4);
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "mouseDownMove", "(IIIJ)V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(6, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "mouseReleased", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "mouseUp", "(III)V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "keyPress", "(CI)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "keypress", "(CI)V", true);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(IIF)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "drawScreen", "(IIF)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(CI)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "keyPress", "(CI)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "mouseClicked", "(III)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "b", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "mouseReleased", "(III)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(IIIJ)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(LLOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "mouseDownDrag", "(IIIJ)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(6, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "b", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "initGui", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "doesGuiPauseGame", "()Z", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitMethodInsn(INVOKEINTERFACE, "me/curlpipesh/pipe/gui/GuiModule", "isPauseGame", "()Z", true);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "d", "()Z", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "me/curlpipesh/pipe/gui/GuiScreen", "doesGuiPauseGame", "()Z", false);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getInstance", "()Lme/curlpipesh/pipe/gui/GuiScreen;", null, null);
            mv.visitCode();
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/gui/GuiScreen", "instance", "Lme/curlpipesh/pipe/gui/GuiScreen;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getCurrentModule", "()Lme/curlpipesh/pipe/gui/GuiModule;", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setCurrentModule", "(Lme/curlpipesh/pipe/gui/GuiModule;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "me/curlpipesh/pipe/gui/GuiScreen", "currentModule", "Lme/curlpipesh/pipe/gui/GuiModule;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "me/curlpipesh/pipe/gui/GuiScreen");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "me/curlpipesh/pipe/gui/GuiScreen", "<init>", "()V", false);
            mv.visitFieldInsn(PUTSTATIC, "me/curlpipesh/pipe/gui/GuiScreen", "instance", "Lme/curlpipesh/pipe/gui/GuiScreen;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
