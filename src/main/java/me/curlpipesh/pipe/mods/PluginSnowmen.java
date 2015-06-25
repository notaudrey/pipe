package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.config.option.NumberOption;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.pipe.util.helpers.Helper;
import org.lwjgl.input.Keyboard;

import java.util.stream.IntStream;

/**
 * Sends a happy message about snowmen to the in-game chat
 *
 * @author c
 * @since 5/23/15
 */
public class PluginSnowmen extends ExecutablePlugin {
    private NumberOption<Integer> snowmenCount = new NumberOption<Integer>("count", 3) {
        @Override
        public Class<Integer> getNumberType() {
            return Integer.class;
        }

        @Override
        public void set(String string) {
            set(Integer.decode(string));
        }
    };

    @Override
    public void init() {
        setName("Snowmen!");
        setKey(Keyboard.KEY_S);
        addModifier(Keyboard.KEY_LCONTROL);
        addOption(snowmenCount);
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, snowmenCount.get()).forEach(i -> sb.append("☃"));
        String s = sb.toString();

        Helper.addChatMessage(s + " ~Snowmen~ " + s);
    }
}
