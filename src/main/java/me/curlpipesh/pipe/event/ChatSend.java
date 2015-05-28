package me.curlpipesh.pipe.event;

import lombok.Getter;
import me.curlpipesh.lib.util.Cancellable;

/**
 * @author c
 * @since 5/27/15
 */
public class ChatSend extends Cancellable {
    @Getter
    private String message;

    public ChatSend(String message) {
        this.message = message;
    }
}
