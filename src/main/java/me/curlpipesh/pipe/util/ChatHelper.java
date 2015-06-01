package me.curlpipesh.pipe.util;

import me.curlpipesh.pipe.event.ChatSend;
import me.curlpipesh.pipe.injectors.GuiChatInjector;
import pw.aria.event.EventManager;

import java.util.Arrays;

/**
 * Used in {@link GuiChatInjector} for
 * redirecting the chat messages to our custom "handler," so that we can push
 * {@link ChatSend} events without too much pain.
 *
 * @author c
 * @since 5/27/15
 */
public class ChatHelper {
    /**
     * Handles the "redirection" of chat messages.
     *
     * @param message The message to tinker with.
     */
    public static void handle(String message) {
        if(!EventManager.push(new ChatSend(message)).isCancelled()) {
            Helper._sendChatMessage(message);
        }
    }

    // TODO Proper "Logger" implementation for this
    public static void log(String... messages) {
        Arrays.stream(messages).forEach(m -> Helper.addChatMessage("§7[§aPipe§7]§r " + m));
    }

    // TODO Proper "Logger" implementation for this
    public static void debug(String... messages) {
        Arrays.stream(messages).forEach(m -> log("§0[§4DEBUG§0]§r " + m));
    }

    // TODO Proper "Logger" implementation for this
    public static void warn(String... messages) {
        Arrays.stream(messages).forEach(m -> log("§8[§cWARNING§8]§r " + m));
    }
}
