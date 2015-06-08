package me.curlpipesh.lib.config;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Interface that indicates that something is configurable, as in that the
 * implementing class will be writing configuration to the disk and loading it.
 *
 * @author c
 * @since 5/23/15
 */
@SuppressWarnings("unused")
public interface Configurable {
    /**
     * Loading the configuration file
     */
    void load();

    /**
     * Saving the configuration file
     */
    void save();

    /**
     * Returns the list of options that will be saved to the configuration
     * file. Note that this list is allowed to be empty.
     *
     * @return The list of options to be saved
     */
    List<Option<?>> getOptions();

    /**
     * Adds an option to be saved. The name of each option must be unique, as
     * methods such as {@link #getOptionByName(String)} will only return one
     * option for a given name.
     *
     * @param option The option to add
     */
    void addOption(Option<?> option);

    /**
     * Removes an option, so that it will no longer be saved
     *
     * @param option The option to remove
     */
    void removeOption(Option<?> option);

    /**
     * Gets an option by name. The name passed in must be a unique name for an
     * option, as if multiple options with the same name are present, only one
     * will be returned.
     *
     * @param name The name of the option to find.
     * @return An {@link Optional} containing the option returned. May contain
     *         <tt>null</tt>.
     */
    Optional<Option<?>> getOptionByName(String name);

    /**
     * Returns the config file for this class. This should not be null.
     *
     * @return The config file for this class
     */
    File getFile();

    /**
     * Sets the config file for this class
     *
     * @param configFile The new config file to use
     */
    void setFile(File configFile);
}
