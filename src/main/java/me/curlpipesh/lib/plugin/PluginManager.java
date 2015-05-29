package me.curlpipesh.lib.plugin;

import lombok.Getter;
import me.curlpipesh.bytecodetools.util.ClassEnumerator;
import me.curlpipesh.lib.manager.AbstractManager;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.lib.annotations.Disabled;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manager for plugins.
 *
 * @author c
 * @since 5/9/15
 */
public class PluginManager extends AbstractManager<Plugin> {
    /**
     * Singleton instance of the plugin manager
     */
    @Getter
    private static final PluginManager instance = new PluginManager();

    private PluginManager() {
    }

    @Override
    public void init() {
        Pipe.log("Loading plugins...");
        Class<?>[] classes = ClassEnumerator.getClassesFromJar(new File(Pipe.class.getProtectionDomain().getCodeSource().getLocation().getFile()), Pipe.class.getClassLoader()).stream().toArray(Class<?>[]::new);

        List<Class<?>> pluginClasses = Arrays.stream(classes)
                .filter(Plugin.class::isAssignableFrom)
                .filter(c -> !Modifier.isAbstract(c.getModifiers()) && !Modifier.isInterface(c.getModifiers()))
                .filter(c -> !c.isAnnotationPresent(Disabled.class))
                .collect(Collectors.toList());
        List<Class<?>> loadFirst = pluginClasses.stream().filter(c -> c.isAnnotationPresent(Load.class))
                .filter(c -> c.getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.BEFORE_ALL))
                .collect(Collectors.toList());
        List<Class<?>> loadLast = pluginClasses.stream().filter(c -> c.isAnnotationPresent(Load.class))
                .filter(c -> c.getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.AFTER_ALL))
                .collect(Collectors.toList());
        pluginClasses.removeAll(loadFirst);
        pluginClasses.removeAll(loadLast);

        loadFirst.forEach(this::instantiate);
        pluginClasses.forEach(this::instantiate);
        loadLast.forEach(this::instantiate);

        for(int pass = 0; pass < 3; pass++) {
            for(Plugin p : getManagedObjects()) {
                if(pass != 1) {
                    if(p.getClass().isAnnotationPresent(Load.class)) {
                        if(pass == 0) {
                            if(p.getClass().getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.INIT_BEFORE_ALL)) {
                                init(p);
                            }
                        }
                        if(pass == 2) {
                            if(p.getClass().getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.INIT_AFTER_ALL)) {
                                init(p);
                            }
                        }
                    }
                } else {
                    if(!p.getClass().isAnnotationPresent(Load.class) ||
                            (p.getClass().isAnnotationPresent(Load.class) &&
                                    p.getClass().getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.NONE))) {
                        init(p);
                    }
                }
            }
        }

        Pipe.log(getManagedObjects().size() + " plugins loaded!");
    }

    private void init(Plugin plugin) {
        plugin.init();
        Pipe.log("Initialized plugin: " + plugin.getName());
    }

    private void instantiate(Class<?> plugin) {
        Pipe.log("Loading plugin: " + plugin.getName());
        try {
            addObject((Plugin) plugin.getConstructor().newInstance());
        } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
