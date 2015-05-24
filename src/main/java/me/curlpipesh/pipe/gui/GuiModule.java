package me.curlpipesh.pipe.gui;

/**
 * @author audrey
 * @since 5/24/15
 */
public interface GuiModule {
    void init();

    void render(int mx, int my, float ptt);

    void keypress(char c, int k);

    void mouseDown(int mx, int my, int mb);

    void mouseDownMove(int mx, int my, int mb, long t);

    void mouseUp(int mx, int my, int mb);

    boolean isPauseGame();
}
