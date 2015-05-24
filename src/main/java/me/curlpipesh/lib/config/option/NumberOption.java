package me.curlpipesh.lib.config.option;

/**
 * @author audrey
 * @since 5/23/15
 */
public class NumberOption<T extends Number> extends BasicOption<T> {
    public NumberOption(String name, T defaultValue) {
        super(name, defaultValue);
    }
}
