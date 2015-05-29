package me.curlpipesh.pipe.util;

import me.curlpipesh.pipe.event.ChatSend;
import me.curlpipesh.pipe.injectors.GuiChatInjector;
import pw.aria.event.EventManager;

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
}
