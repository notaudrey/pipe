package me.curlpipesh.lib.util;

import lombok.Data;

/**
 * @author c
 * @since 5/27/15
 */
@Data
public abstract class Cancellable {
    private boolean cancelled = false;
}
