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
        FieldVisitor fv;
        MethodVisitor mv;
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
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/IllegalAccessException");
            mv.visitLabel(l0);
            mv.visitLineNumber(47, l0);
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/util/Constants", "DEBUGMODEFIELD", "Ljava/lang/reflect/Field;");
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getGameSettings", "()Ljava/lang/Object;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Field", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
            mv.visitLabel(l1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l2);
            mv.visitLineNumber(48, l2);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/IllegalAccessException"});
            mv.visitVarInsn(ASTORE, 0);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(49, l3);
            mv.visitTypeInsn(NEW, "java/lang/RuntimeException");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V", false);
            mv.visitInsn(ATHROW);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLocalVariable("e", "Ljava/lang/IllegalAccessException;", null, l3, l4, 0);
            mv.visitMaxs(3, 1);
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
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/IllegalAccessException");
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/reflect/InvocationTargetException");
            mv.visitLabel(l0);
            mv.visitLineNumber(71, l0);
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/util/Constants", "GETSTRINGWIDTH", "Ljava/lang/reflect/Method;");
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getFontRenderer", "()Ljava/lang/Object;", false);
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            mv.visitLabel(l1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l2);
            mv.visitLineNumber(72, l2);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/ReflectiveOperationException"});
            mv.visitVarInsn(ASTORE, 1);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(73, l3);
            mv.visitTypeInsn(NEW, "java/lang/RuntimeException");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V", false);
            mv.visitInsn(ATHROW);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLocalVariable("e1", "Ljava/lang/ReflectiveOperationException;", null, l3, l4, 1);
            mv.visitLocalVariable("e", "Ljava/lang/String;", null, l0, l4, 0);
            mv.visitMaxs(6, 2);
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
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/IllegalAccessException");
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(123, l3);
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/util/Constants", "LIGHTBRIGHTNESSTABLEFIELD", "Ljava/lang/reflect/Field;");
            mv.visitInsn(ICONST_1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Field", "setAccessible", "(Z)V", false);
            mv.visitLabel(l0);
            mv.visitLineNumber(125, l0);
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/util/Constants", "LIGHTBRIGHTNESSTABLEFIELD", "Ljava/lang/reflect/Field;");
            mv.visitFieldInsn(GETSTATIC, "me/curlpipesh/pipe/util/Constants", "WORLDPROVIDERFIELD", "Ljava/lang/reflect/Field;");
            mv.visitMethodInsn(INVOKESTATIC, "me/curlpipesh/pipe/util/Helper", "getWorld", "()Ljava/lang/Object;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Field", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Field", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
            mv.visitTypeInsn(CHECKCAST, "[F");
            mv.visitTypeInsn(CHECKCAST, "[F");
            mv.visitLabel(l1);
            mv.visitInsn(ARETURN);
            mv.visitLabel(l2);
            mv.visitLineNumber(126, l2);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/IllegalAccessException"});
            mv.visitVarInsn(ASTORE, 0);
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLineNumber(127, l4);
            mv.visitTypeInsn(NEW, "java/lang/IllegalStateException");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/IllegalStateException", "<init>", "(Ljava/lang/Throwable;)V", false);
            mv.visitInsn(ATHROW);
            Label l5 = new Label();
            mv.visitLabel(l5);
            mv.visitLocalVariable("e", "Ljava/lang/IllegalAccessException;", null, l4, l5, 0);
            mv.visitMaxs(3, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
