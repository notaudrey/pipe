package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.GLRenderer;
import org.lwjgl.input.Keyboard;

/**
 * @author audrey
 * @since 5/24/15
 */
public class PluginGui extends ExecutablePlugin {
    @Override
    protected void execute() {
        Helper.displayGuiModule(new GuiModule() {
            @Override
            public void init() {
                Pipe.log("Yay! We have a GuiModule working!");
            }

            @Override
            public void render(int mx, int my, float ptt) {
                GLRenderer.drawRect(100, 100, 200, 200, 0x77FF0000);
            }

            @Override
            public void keypress(char c, int k) {
                if(k == Keyboard.KEY_ESCAPE) {
                    Helper.displayGuiScreen(null);
                }
            }

            @Override
            public void mouseDown(int mx, int my, int mb) {

            }

            @Override
            public void mouseDownMove(int mx, int my, int mb, long t) {

            }

            @Override
            public void mouseUp(int mx, int my, int mb) {

            }

            @Override
            public boolean isPauseGame() {
                return false;
            }
        });
    }

    @Override
    public void init() {
        setName("Gui");
        setKey(Keyboard.KEY_Y);
    }
}
