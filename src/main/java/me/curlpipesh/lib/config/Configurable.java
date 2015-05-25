package me.curlpipesh.lib.config;

import me.curlpipesh.lib.config.file.ConfigFile;

import java.util.List;

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
     * Adds an option to be saved
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
     * Returns the config file for this class. This should not be null.
     *
     * @return The config file for this class
     */
    ConfigFile getConfig();

    /**
     * Sets the config file for this class
     *
     * @param configFile The new config file to use
     */
    void setConfig(ConfigFile configFile);
}
