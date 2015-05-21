package me.curlpipesh.pipe.event;

import lombok.Getter;

/**
 * @author audrey
 * @since 5/2/15
 */
public class Keypress {
    @Getter
    private final int key;

    public Keypress(int key) {
        this.key = key;
    }
}
