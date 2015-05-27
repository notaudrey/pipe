package me.curlpipesh.lib.manager;

import java.util.Arrays;
import java.util.List;

/**
 * Class used for the management of arbitrary objects.
 *
 * @param <T> The type of objects that this manager will manage
 * @author c
 * @since 5/9/15
 */
@SuppressWarnings({"unused", "unchecked"})
public interface Manager<T> {
    /**
     * Initializes this manager. Used for things such as adding default objects
     */
    void init();

    /**
     * Adds an object to be managed
     *
     * @param object The object to be managed
     */
    void addObject(T object);

    /**
     * Adds multiple objects to be managed
     *
     * @param objects A vararg of objects to be managed
     */
    default void addObjects(T... objects) {
        Arrays.stream(objects).forEach(this::addObject);
    }

    /**
     * Removes a currently managed object
     *
     * @param object The object to remove
     */
    void removeObject(T object);

    /**
     * Removes multiple objects from management
     *
     * @param objects A vararg of objects to remove
     */
    default void removeObjects(T... objects) {
        Arrays.stream(objects).forEach(this::removeObject);
    }

    /**
     * Returns the list of objects that this manager currently manages
     *
     * @return The list of objects that this manager currently manages
     */
    List<T> getManagedObjects();

    /**
     * Returns a manged object based on class.
     *
     * @param clazz The class of the object to be found
     * @return The object, or null if no such object exists
     */
    @SuppressWarnings("unchecked")
    default T getObjectByClass(Class<? extends T> clazz) {
        return getManagedObjects().parallelStream().filter(o -> o.getClass().equals(clazz)).findFirst().orElse(null);
    }

    /**
     * Clears the list of managed objects.
     */
    void clearObjects();
}
