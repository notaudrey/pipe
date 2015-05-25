package me.curlpipesh.pipe.util;

import lombok.Getter;

import java.text.DecimalFormat;

/**
 * @author audrey
 * @since 5/24/15
 */
public final class ProfiledEvent {
    @Getter
    private final String event;

    @Getter
    private final long time;

    @Getter
    private final long timeMillis;

    public ProfiledEvent(String event, long time) {
        this.event = event;
        this.time = time;
        timeMillis = time / 1_000_000L;
    }
}
