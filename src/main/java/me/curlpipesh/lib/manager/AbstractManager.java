package me.curlpipesh.lib.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author audrey
 * @since 5/9/15
 */
public abstract class AbstractManager<T> implements Manager<T> {
    private final ArrayList<T> objects;

    public AbstractManager() {
        objects = new ArrayList<>();
    }

    @Override
    public void addObject(T object) {
        objects.add(object);
    }

    @Override
    public void removeObject(T object) {
        objects.remove(object);
    }

    @Override
    public List<T> getManagedObjects() {
        return objects;
    }

    @Override
    public void clearObjects() {
        objects.clear();
    }
}
