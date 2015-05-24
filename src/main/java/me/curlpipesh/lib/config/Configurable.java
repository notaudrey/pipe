package me.curlpipesh.lib.config;

import me.curlpipesh.lib.config.file.ConfigFile;
import me.curlpipesh.lib.config.option.Option;

import java.util.List;

/**
 * @author audrey
 * @since 5/23/15
 */
public interface Configurable {
    void load();

    void save();

    List<Option<?>> getOptions();

    void addOption(Option<?> option);

    void removeOption(Option<?> option);

    ConfigFile getConfig();

    void setConfig(ConfigFile configFile);
}
