package me.curlpipesh.lib.manager;

import java.util.Arrays;
import java.util.List;

/**
 * @author audrey
 * @since 5/9/15
 */
@SuppressWarnings("unused")
public interface Manager<T> {
    void init();

    void addObject(T object);

    default void addObjects(T... objects) {
        Arrays.stream(objects).forEach(this::addObject);
    }

    void removeObject(T object);

    default void removeObjects(T... objects) {
        Arrays.stream(objects).forEach(this::removeObject);
    }

    List<T> getManagedObjects();

    @SuppressWarnings("unchecked")
    default T getObjectByClass(Class<? super T> clazz) {
        return getManagedObjects().parallelStream().filter(o -> o.getClass().equals(clazz)).findFirst().orElse(null);
    }

    void clearObjects();
}
