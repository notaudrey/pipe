package me.curlpipesh.lib.config.file;

import me.curlpipesh.lib.config.file.format.ConfigFormat;

import java.io.File;

/**
 * @author audrey
 * @since 5/23/15
 */
public class ConfigFile {
    private ConfigFormat format = ConfigFormat.JSON;
    private File file;

    public ConfigFile() {

    }
}
