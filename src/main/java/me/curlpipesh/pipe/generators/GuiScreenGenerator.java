package me.curlpipesh.pipe.generators;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

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

        cw.visit(49, ACC_PUBLIC + ACC_SUPER, "pw/slacks/bytey/defined/GuiScreen", null, "axu", null);

        cw.visitSource("GuiScreen.java", null);
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(8, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lpw/slacks/bytey/defined/GuiScreen;", null, l0, l1, 0);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "drawScreen", "(IIF)V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(IIF)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "drawScreen", "(IIF)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "a", "(IIF)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "keyPress", "(CI)V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(CI)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "keyPress", "(CI)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "a", "(CI)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "mouseClicked", "(III)V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "a", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "mouseClicked", "(III)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "a", "(III)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "mouseReleased", "(III)V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "b", "(III)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "mouseReleased", "(III)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "b", "(III)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "mouseDownDrag", "(IIIJ)V", null, null);
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
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "mouseDownDrag", "(IIIJ)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(LLOAD, 4);
            mv.visitMethodInsn(INVOKESPECIAL, "axu", "a", "(IIIJ)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(6, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "initGui", "()V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "b", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "pw/slacks/bytey/defined/GuiScreen", "initGui", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
