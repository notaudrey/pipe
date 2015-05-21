package me.curlpipesh.lib.util;

/**
 * @author audrey
 * @since 5/14/15
 */
public interface Statused {
    String getStatus();

    void setStatus(String status);

    boolean isStatusShown();
}
