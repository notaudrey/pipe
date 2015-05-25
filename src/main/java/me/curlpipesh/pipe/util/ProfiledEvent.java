package me.curlpipesh.pipe.util;

import lombok.Getter;

/**
 * Representation of a profiled event
 *
 * @author c
 * @since 5/24/15
 */
public final class ProfiledEvent {
    /**
     * Name of the event
     */
    @Getter
    private final String event;

    /**
     * Total time it takes for the event to fire across all listeners
     */
    @Getter
    private final long time;

    /**
     * {@link #time} in milliseconds.
     */
    @Getter
    private final long timeMillis;

    public ProfiledEvent(String event, long time) {
        this.event = event;
        this.time = time;
        timeMillis = time / 1_000_000L;
    }
}
