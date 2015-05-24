package me.curlpipesh.lib.config;

/**
 * @author audrey
 * @since 5/23/15
 */
public interface Option<T> {
    T get();

    void set(T t);

    String name();
}
