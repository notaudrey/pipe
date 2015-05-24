package me.curlpipesh.pipe.gui;

/**
 * @author audrey
 * @since 5/24/15
 */
public abstract class GuiScreen {
    public abstract void drawScreen(int i, int j, float f);

    public void a(int i, int j1, float f) {
        drawScreen(i, j1, f);
    }

    public abstract void keyPress(char c, int i);

    public void a(char c, int i) {
        keyPress(c, i);
    }

    public abstract void mouseClicked(int mx, int my, int button);

    public void a(int i, int j, int k) {
        mouseClicked(i, j, k);
    }

    public abstract void mouseReleased(int mx, int my, int button);

    public void b(int i, int j, int k) {
        mouseReleased(i, j, k);
    }

    public abstract void mouseDownDrag(int mx, int my, int button, long timeSinceLastClick);

    public void a(int i, int j, int k, long l) {
        mouseDownDrag(i, j, k, l);
    }

    public abstract void initGui();

    public void b() {
        initGui();
    }
}
