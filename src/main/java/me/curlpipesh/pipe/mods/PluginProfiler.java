package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.util.GLRenderer;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.ProfiledEvent;
import me.curlpipesh.pipe.util.TimeHelper;
import org.lwjgl.input.Keyboard;
import pw.aria.event.EventManager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Plugin that displays a GUI with information about event timings, memory
 * usage, and other statistics.
 *
 * @author c
 * @since 5/24/15
 */
public class PluginProfiler extends ExecutablePlugin {
    /**
     * The {@link GuiModule} that contains profiling information
     */
    private GuiModule profilerModule;

    @Override
    public void init() {
        setName("Pipe Profiler");
        setKey(Keyboard.KEY_D);
        addModifier(Keyboard.KEY_LCONTROL);
        addModifier(Keyboard.KEY_LSHIFT);
        profilerModule = new GuiModule() {
            private final DecimalFormat df = new DecimalFormat("#.##");
            private final List<ProfiledEvent> events = new ArrayList<>();

            private long lastTime = TimeHelper.getTimeMillis();
            private long totalEventTime = 1;
            private long totalMemory = 1;
            private long maxMemory = 1;
            private long freeMemory = 1;

            @Override
            public void init() {

            }

            @Override
            public void render(int mx, int my, float ptt) {
                GLRenderer.drawRect(0, 0, Helper.getWidth() / Helper.getScale(), Helper.getHeight() / Helper.getScale(), 0x77000000);
                long now = TimeHelper.getTimeMillis();
                if(now - lastTime >= 1000L) {
                    // Do update
                    lastTime = now;
                    events.clear();
                    totalEventTime = 0;
                    for(Map.Entry<Class<?>, Long> entry : EventManager.getEventFireTimes().entrySet()) {
                        totalEventTime += entry.getValue();
                        events.add(new ProfiledEvent(entry.getKey().getSimpleName(), entry.getValue()));
                    }
                    freeMemory = Runtime.getRuntime().freeMemory();
                    maxMemory = Runtime.getRuntime().maxMemory();
                    totalMemory = Runtime.getRuntime().totalMemory();
                }
                // maxMemory
                GLRenderer.drawRect(128, 2, 100, 10, 0xFF0000FF);
                // totalMemory
                GLRenderer.drawRect(128, 2, ((double) totalMemory / (double) maxMemory) * 100, 10, 0xFF00FF00);
                // freeMemory
                GLRenderer.drawRect(128, 2, ((double) freeMemory / (double) maxMemory) * 100, 10, 0xFFFF0000);
                Helper.drawString("Available Memory: " + (long) (maxMemory / 1_000_000D) + "MB", 280, 2, 0xFFFFFFFF, true);
                Helper.drawString("Allocated Memory: " + (long) (totalMemory / 1_000_000D) + "MB", 280, 13, 0xFFFFFFFF, true);
                Helper.drawString("Used Memory:      " + (long) (freeMemory / 1_000_000D) + "MB", 280, 24, 0xFFFFFFFF, true);

                Helper.drawString("Total event time: " + (long) (totalEventTime / 1_000_000D) + "ms", 128, 12, 0xFFFFFFFF, true);
                int yOffset = 12;
                for(ProfiledEvent e : events) {
                    Helper.drawString(e.getEvent() + ": " + e.getTimeMillis() + "ms (" + df.format(e.getTime() / totalEventTime) + ")%",
                            128, yOffset += Helper.getFontHeight() + 2, 0xFFFFFFFF, true);
                }
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
        };
    }

    @Override
    public void execute() {
        Helper.displayGuiModule(profilerModule);
    }
}
