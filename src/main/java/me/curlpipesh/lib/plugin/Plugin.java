package me.curlpipesh.lib.plugin;

import me.curlpipesh.lib.util.Named;
import me.curlpipesh.lib.util.Statused;
import me.curlpipesh.lib.util.Toggleable;

/**
 * @author audrey
 * @since 5/9/15
 */
public interface Plugin extends Named, Statused {
    void init();

    void load();

    void save();
}
