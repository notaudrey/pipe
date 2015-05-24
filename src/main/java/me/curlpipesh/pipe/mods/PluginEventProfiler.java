package me.curlpipesh.pipe.mods;

import lombok.Getter;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;
import pw.aria.event.EventManager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author audrey
 * @since 5/24/15
 */
public class PluginEventProfiler extends ExecutablePlugin {
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void execute() {
        long total = 0L;
        List<ProfiledEvent> events = new ArrayList<>();
        for(Map.Entry<Class<?>, Long> entry : EventManager.getEventFireTimes().entrySet()) {
            total += entry.getValue();
            events.add(new ProfiledEvent(entry.getKey().getSimpleName(), entry.getValue()));
        }
        Helper.addChatMessage("§7Event times:");
        Helper.addChatMessage("§7------------");
        for(ProfiledEvent e : events) {
            Helper.addChatMessage("§7" + e.getEvent() + ": " + (e.getTime()/1_000_000L) + "ms (" +
                    df.format((e.getTime() / (double)total) * 100) + "%)");
        }
        Helper.addChatMessage("");
        Helper.addChatMessage("§7Total: " + (long) (total / 1_000_000D) + "ms");
        Helper.addChatMessage("§7------------");
    }

    @Override
    public void init() {
        setName("Event Profiler");
        setKey(Keyboard.KEY_P);
        addModifier(Keyboard.KEY_LCONTROL);
    }

    private final class ProfiledEvent {
        @Getter
        private final String event;

        @Getter
        private final long time;

        public ProfiledEvent(String event, long time) {
            this.event = event;
            this.time = time;
        }
    }
}
