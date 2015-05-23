package me.curlpipesh.pipe.config.option;

/**
 * @author audrey
 * @since 5/23/15
 */
public abstract class BasicOption<T> implements Option<T> {
    private final String name;
    private T value;

    public BasicOption(String name, T defaultValue) {
        this.name = name;
        value = defaultValue;
    }

    @Override
    public String name() {
        return name;
    }

    public T get() {
        return value;
    }

    public void set(T t) {
        value = t;
    }
}
