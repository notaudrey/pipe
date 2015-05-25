package me.curlpipesh.pipe.util;

import me.curlpipesh.gl.tessellation.Tessellator;
import me.curlpipesh.gl.tessellation.impl.VAOTessellator;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.InvocationTargetException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_MULTISAMPLE;
import static org.lwjgl.opengl.GL13.GL_SAMPLE_ALPHA_TO_COVERAGE;

/**
 * @author audrey
 * @since 4/30/15
 */
public class GLRenderer {
    private static final Tessellator tess = new VAOTessellator(2048);

    public static void drawString(String s, float x, float y, int color, boolean shadow) {
        Helper.drawString(s, x, y, color, shadow);
    }

    public static void pre() {
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glPushMatrix();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_TEXTURE_2D);
        glShadeModel(GL_SMOOTH);
        glDisable(GL_ALPHA_TEST);
        glEnable(GL_MULTISAMPLE);
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        glEnable(GL_POINT_SMOOTH);
        glHint(GL_POINT_SMOOTH_HINT, GL_NICEST);
        glEnable(GL_POLYGON_SMOOTH);
        glHint(GL_POLYGON_SMOOTH_HINT, GL_NICEST);
        glEnable(GL_SAMPLE_ALPHA_TO_COVERAGE);
    }

    public static void post() {
        glDisable(GL_SAMPLE_ALPHA_TO_COVERAGE);
        glDisable(GL_POLYGON_SMOOTH);
        glDisable(GL_POINT_SMOOTH);
        glDisable(GL_LINE_SMOOTH);
        glDisable(GL_MULTISAMPLE);
        glEnable(GL_ALPHA_TEST);
        glShadeModel(GL_FLAT);
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glPopMatrix();
        glPopAttrib();
    }

    public static void drawRect(double x, double y, double w, double h, int c) {
        pre();
        tess.startDrawing(GL_QUADS).color(c)
                .addVertex(x, y, 0)
                .addVertex(x, y + h, 0)
                .addVertex(x + w, y + h, 0)
                .addVertex(x + w, y, 0)
                .bindAndDraw();
        post();
    }

    public static void drawLine(Vec3 a, Vec3 b, int color, float size) {
        drawLine(a.x(), a.y(), a.z(), b.x(), b.y(), b.z(), color, size);
    }

    public static void drawLine(double x, double y, double z, double xx, double yy, double zz, int c, float size) {
        glLineWidth(size);
        tess.startDrawing(GL_LINES).color(c)
                .addVertex(x, y, z)
                .addVertex(xx, yy, zz)
                .bindAndDraw();
        glLineWidth(1.0F);
    }

    public static void drawBoxFromPoints(Vec3 min, Vec3 max, int color) {
        GL11.glDisable(GL11.GL_CULL_FACE);
        tess
                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) min.x(), (float) min.y(), (float) min.z())
                .addVertex((float) max.x(), (float) min.y(), (float) min.z())
                .addVertex((float) max.x(), (float) max.y(), (float) min.z())
                .addVertex((float) min.x(), (float) max.y(), (float) min.z())
                .bindAndDraw()

                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) min.x(), (float) min.y(), (float) min.z())
                .addVertex((float) min.x(), (float) min.y(), (float) max.z())
                .addVertex((float) min.x(), (float) max.y(), (float) max.z())
                .addVertex((float) min.x(), (float) max.y(), (float) min.z())
                .bindAndDraw()

                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) min.x(), (float) max.y(), (float) min.z())
                .addVertex((float) max.x(), (float) max.y(), (float) min.z())
                .addVertex((float) max.x(), (float) max.y(), (float) max.z())
                .addVertex((float) min.x(), (float) max.y(), (float) max.z())
                .bindAndDraw()

                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) max.x(), (float) min.y(), (float) min.z())
                .addVertex((float) max.x(), (float) max.y(), (float) min.z())
                .addVertex((float) max.x(), (float) max.y(), (float) max.z())
                .addVertex((float) max.x(), (float) min.y(), (float) max.z())
                .bindAndDraw()

                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) min.x(), (float) min.y(), (float) max.z())
                .addVertex((float) max.x(), (float) min.y(), (float) max.z())
                .addVertex((float) max.x(), (float) max.y(), (float) max.z())
                .addVertex((float) min.x(), (float) max.y(), (float) max.z())
                .bindAndDraw()

                .startDrawing(GL_QUADS)
                .color(color)
                .addVertex((float) min.x(), (float) min.y(), (float) min.z())
                .addVertex((float) max.x(), (float) min.y(), (float) min.z())
                .addVertex((float) max.x(), (float) min.y(), (float) max.z())
                .addVertex((float) min.x(), (float) min.y(), (float) max.z())
                .bindAndDraw();
        GL11.glEnable(GL11.GL_CULL_FACE);
    }

    public static void scissor(final double x, final double y, final double w, final double h) {
        final int factor = Helper.getScale();
        final int height = Helper.getHeight() / factor;

        final double x2 = x + w;
        final double y2 = y + h;

        glScissor((int) (x * factor), (int) ((height - y2) * factor),
                (int) ((x2 - x) * factor), (int) ((y2 - y) * factor));
    }
}
