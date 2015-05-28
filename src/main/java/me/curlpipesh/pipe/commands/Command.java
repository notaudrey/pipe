package me.curlpipesh.pipe.commands;

/**
 * The basis of all commands. This class must always be the base class of
 * commands for any command system made for this client, as this class is the
 * one that is always expected to be available for the client.
 *
 * @author c
 * @since 5/27/15
 */
public interface Command {
    /**
     * Runs the command. Note that, while this method is intended to return a
     * boolean value to indicate whether the command's execution succeeded or
     * failed, that will not always be the case. Returning seemingly
     * nonsensical values will not be checked for, as
     * <ol>
     *     <li>It really can't be checked for anyway</li>
     *     <li>Using this to get around quirks in the current command system
     *     isn't a bug per se</li>
     * </ol>
     *
     * @param command The name of the command
     * @param args The arguments passed to the command
     * @return <tt>true</tt> if the command succeeds, <tt>false</tt> otherwise.
     */
    boolean run(String command, String[] args);
}
