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
public abstract class NumberOption<T extends Number> extends BasicOption<T> {
    public NumberOption(String name, T defaultValue) {
        super(name, defaultValue);
    }

    /**
     * Returns the type of number that this class holds. The intent of this
     * method is to make typecasting - and therefore parsing - easier, since
     * the actual "number" aspect of this option is wrapped in a generic, and
     * is therefore not determined by this class, but by subclasses of it.
     *
     * @return The type of number that this <tt>Option</tt> holds
     */
    public abstract Class<T> getNumberType();
}
