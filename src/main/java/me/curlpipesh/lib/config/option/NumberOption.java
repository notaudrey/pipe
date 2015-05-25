package me.curlpipesh.lib.config.option;

/**
 * Option that contains a single number. Numbers can be:
 * <ul>
 * <li>{@link Double}</li>
 * <li>{@link Float}</li>
 * <li>{@link Long}</li>
 * <li>{@link Short}</li>
 * <li>{@link Integer}</li>
 * <li>Any other valid subclass of {@link Number}</li>
 * </ul>
 *
 * @author c
 * @since 5/23/15
 */
public class NumberOption<T extends Number> extends BasicOption<T> {
    public NumberOption(String name, T defaultValue) {
        super(name, defaultValue);
    }
}
