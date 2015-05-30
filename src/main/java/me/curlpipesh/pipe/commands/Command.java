package me.curlpipesh.pipe.commands;

import me.curlpipesh.pipe.util.Helper;

import java.util.Arrays;
import java.util.List;

/**
 * The basis of all commands. This class must always be the base class of
 * commands for any command system made for this client, as this class is the
 * one that is always expected to be available for the client.
 *
 * @author c
 * @since 5/27/15
 */
@SuppressWarnings("unused")
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
     * @param command The full command string passed in
     * @param args The arguments passed to the command
     * @return <tt>true</tt> if the command succeeds, <tt>false</tt> otherwise.
     */
    boolean run(String command, String[] args);

    /**
     * Returns the name of this command. While this class could just extend
     * {@link me.curlpipesh.lib.util.Named} and be done with it that way, this
     * is not the case so that we avoid having to have an empty implementation
     * of a <tt>setName</tt> method. Even though this could be avoided by
     * having a <tt>default</tt> method in this class which overrides said
     * unwanted method, this is not done so that we avoid having an unnecessary
     * method in here.
     *
     * @return The name of this command.
     */
    String getName();

    /**
     * Gets the description of this command. This is mainly intended to be used
     * for a `/help'-style command's output.
     *
     * @return The description of this command.
     */
    String getDescription();

    /**
     * Returns the usage help for this command. For example,
     *     <tt>/command [thing <arg>], [thing2 [arg]]</tt>
     *
     * @return The usage help for this command
     */
    default String getUsage() {
        throw new IllegalStateException("Trying to call the default getUsage() implementation!");
    }

    /**
     * Whether or not the command system should try to automagically generate
     * the usage information for this command. If this method is overridden to
     * return <tt>false</tt>, then {@link #getUsage()} <b>must</b> also be
     * overridden; failure to do so will result in an
     * {@link IllegalStateException} being thrown.
     *
     * @return Whether or not the command system should try to generate help
     *         for this command
     */
    default boolean generateUsage() {
        return true;
    }

    /**
     * Returns the list of commands that are subcommands of this command. The
     * intent of having this method is to make "arguments" to commands become a
     * simpler process to do: instead of having to parse out the <tt>args</tt>
     * array manually in {@link #run(String, String[])}, the command system is
     * expected to implement functionality that will search through this list
     * of subcommands in order to find the appropriate one for such an action.
     *
     * @return The list of subcommands of this command
     */
    List<Command> getSubcommands();

    /**
     * Whether or not this command is intended to take raw input. If this
     * method returns true, then the subcommands gathered from
     * {@link #getSubcommands()} will be ignored.
     *
     * @return Whether or not this command is intended to take raw input
     */
    boolean takesRawInput();

    /**
     * Sets whether or not this command is intended to take raw input.
     *
     * @see {@link #takesRawInput()}
     * @param e The new state of taking raw input
     */
    void setRawInput(boolean e);

    /**
     Adds an array of strings to the in-game chat. The reason why this method
     * exists instead of just using {@link Helper#addChatMessage(String)} is
     * because this allows us to be able to "plug in" different ways of adding
     * the messages, if we wanted, as well as so that we don't have to add in
     * any/all formatting in each "logging" method call.
     *
     * @param messages The array of messages to add to the in-game chat
     */
    default void addChatMessage(String... messages) {
        addChatMessage('f', messages);
    }

    /**
     * Adds an array of strings to the in-game chat. The reason why this method
     * exists instead of just using {@link Helper#addChatMessage(String)} is
     * because this allows us to be able to "plug in" different ways of adding
     * the messages, if we wanted, as well as so that we don't have to add in
     * any/all formatting in each "logging" method call.
     *
     * @param color The Minecraft color code to use for the entire message
     * @param messages The array of messages to add to the in-game chat
     */
    default void addChatMessage(char color, String... messages) {
        Arrays.stream(messages).sequential().forEach(m -> Helper.addChatMessage("§" + color + "> " + m));
    }
}
