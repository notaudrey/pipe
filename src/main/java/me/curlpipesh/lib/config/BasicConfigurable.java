package me.curlpipesh.lib.config;

import me.curlpipesh.lib.config.file.ConfigFile;

import java.util.List;

/**
 * @author audrey
 * @since 5/23/15
 */
public class BasicConfigurable implements Configurable {
    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public List<Option<?>> getOptions() {
        return null;
    }

    @Override
    public void addOption(Option<?> option) {

    }

    @Override
    public void removeOption(Option<?> option) {

    }

    @Override
    public ConfigFile getConfig() {
        return null;
    }

    @Override
    public void setConfig(ConfigFile configFile) {

    }
}
