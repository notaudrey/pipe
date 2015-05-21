package me.curlpipesh.pipe.util;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author audrey
 * @since 5/20/15
 */
public class HelperGenerator {
    public static byte[] generate() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        @SuppressWarnings("unused")
        FieldVisitor fv;
        MethodVisitor mv;
        @SuppressWarnings("unused")
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "me/curlpipesh/pipe/util/Helper", null, "java/lang/Object", null);

        cw.visitSource("Helper.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(12, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lme/curlpipesh/pipe/util/Helper;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "isWorldNull", "()Z", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(16, l0);
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getWorld", "()Ljava/lang/Object;", false);
            Label l1 = new Label();
            mv.visitJumpInsn(IFNONNULL, l1);
            mv.visitInsn(ICONST_1);
            Label l2 = new Label();
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(ICONST_0);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{Opcodes.INTEGER});
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getMinecraft", "()Ljava/lang/Object;", null, null);
            mv.visitCode();
            mv.visitLabel(new Label());
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getWorld", "()Ljava/lang/Object;", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitFieldInsn(GETFIELD, "Lave;", "f", "Lbdb;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getPlayer", "()Ljava/lang/Object;", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitFieldInsn(GETFIELD, "Lave;", "h", "Lbew;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getGameSettings", "()Ljava/lang/Object;", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitFieldInsn(GETFIELD, "Lave;", "t", "Lavh;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "isIngameGuiInDebugMode", "()Z", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitFieldInsn(GETFIELD, "Lave;", "t", "Lavh;");
            mv.visitFieldInsn(GETFIELD, "Lavh;", "aA", "Z");
            mv.visitInsn(IRETURN);
            mv.visitMaxs(3, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getFontRenderer", "()Ljava/lang/Object;", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "ave", "A", "()Lave;", false);
            mv.visitFieldInsn(GETFIELD, "Lave;", "k", "Lavn;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getFontHeight", "()I", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getFontRenderer", "()Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "avn");
            mv.visitFieldInsn(GETFIELD, "Lavn;", "a", "I");
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getStringWidth", "(Ljava/lang/String;)I", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getFontRenderer", "()Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "avn");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "avn", "a", "(Ljava/lang/String;)I", false);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(4, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "drawString", "(Ljava/lang/String;FFIZ)V", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getFontRenderer", "()Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "avn");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(FLOAD, 1);
            mv.visitVarInsn(FLOAD, 2);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(ILOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "avn", "a", "(Ljava/lang/String;FFIZ)I", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(6, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getLoadedEntities", "()Ljava/util/List;", "()Ljava/util/List<*>;", null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getWorld", "()Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "adm");
            mv.visitFieldInsn(GETFIELD, "Ladm;", "f", "Ljava/util/List;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 0);
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "getLightBrightnessTable", "()[F", null, null);
            mv.visitCode();
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getWorld", "()Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "adm");
            mv.visitFieldInsn(GETFIELD, "Ladm;", "t", "Lanm;");
            mv.visitFieldInsn(GETFIELD, "Lanm;", "f", "[F");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
