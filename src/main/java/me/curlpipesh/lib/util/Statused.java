package me.curlpipesh.lib.util;

/**
 * An object that can have a status
 *
 * @author c
 * @since 5/14/15
 */
public interface Statused {
    /**
     * Returns the current status of the object
     *
     * @return The current status of the object
     */
    String getStatus();

    /**
     * Sets the status of the object
     *
     * @param status The new status of the object
     */
    void setStatus(String status);

    /**
     * Returns whether or not the status of this object is supposed to be shown
     *
     * @return True if the status is supposed to be shown, false otherwise.
     */
    boolean isStatusShown();
}
