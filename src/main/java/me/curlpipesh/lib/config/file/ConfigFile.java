package me.curlpipesh.lib.config.file;

import lombok.Data;
import me.curlpipesh.lib.config.file.format.ConfigFormat;

import java.io.File;

/**
 * @author audrey
 * @since 5/23/15
 */
@Data
public class ConfigFile {
    private ConfigFormat format;
    private File file;

    public ConfigFile(ConfigFormat format, File file) {
        this.format = format;
        this.file = file;
    }
}
