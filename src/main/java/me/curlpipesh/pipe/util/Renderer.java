package me.curlpipesh.pipe.util;

import me.curlpipesh.gl.tessellation.Tessellator;
import me.curlpipesh.gl.tessellation.impl.VAOTessellator;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_MULTISAMPLE;
import static org.lwjgl.opengl.GL13.GL_SAMPLE_ALPHA_TO_COVERAGE;

/**
 * @author audrey
 * @since 4/30/15
 */
public class Renderer {
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

    public static void drawBox(double x, double y, double z, double w, double h, double d, int c) {
        tess.startDrawing(GL_QUADS).color(c)
                .addVertex(x, y, z)
                .addVertex(x, y, z + d)
                .addVertex(x + w, y, z + d)
                .addVertex(x + w, y, z)
                .bindAndDraw()
                .startDrawing(GL_QUADS).color(c)
                .addVertex(x, y + h, z)
                .addVertex(x, y + h, z + d)
                .addVertex(x + w, y + h, z + d)
                .addVertex(x + w, y + h, z)
                .bindAndDraw();
    }

    public static void drawLine(double x, double y, double z, double xx, double yy, double zz, int c) {
        pre();
        tess.startDrawing(GL_LINES).color(c)
                .addVertex(x, y, z)
                .addVertex(xx, yy, zz)
                .bindAndDraw();
        post();
    }
}
