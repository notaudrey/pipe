package me.curlpipesh.lib.plugin;

import lombok.Getter;
import me.curlpipesh.lib.annotations.Disabled;
import me.curlpipesh.lib.manager.AbstractManager;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.util.ClassMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
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
        List<Class<?>> pluginClasses = ClassMapper.getMappedClasses().stream()
                // Is a plugin
                .filter(Plugin.class::isAssignableFrom)
                // Not abstract/interface
                .filter(c -> !Modifier.isAbstract(c.getModifiers()) && !Modifier.isInterface(c.getModifiers()))
                // Not disabled
                .filter(c -> !c.isAnnotationPresent(Disabled.class))
                .collect(Collectors.toList());
        // Ugly, I know. Done to ensure that @Load "directives" are followed.
        List<Class<?>> loadFirst = pluginClasses.stream()
                // Should be loaded weirdly
                .filter(c -> c.isAnnotationPresent(Load.class))
                // Load first
                .filter(c -> c.getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.BEFORE_ALL))
                .collect(Collectors.toList());
        List<Class<?>> loadLast = pluginClasses.stream()
                // Should be loaded weirdly
                .filter(c -> c.isAnnotationPresent(Load.class))
                // Load last
                .filter(c -> c.getDeclaredAnnotation(Load.class).priority().equals(LoadPriority.AFTER_ALL))
                .collect(Collectors.toList());
        // Remove from "normal" list
        pluginClasses.removeAll(loadFirst);
        pluginClasses.removeAll(loadLast);

        // Do the loading
        loadFirst.forEach(this::instantiate);
        pluginClasses.forEach(this::instantiate);
        loadLast.forEach(this::instantiate);

        // Do multiple passes so that we can use the @Load annotation correctly
        // Pass 0: Before all
        // Pass 1: Normal
        // Pass 2: After all
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
        Pipe.log("Loaded plugin: " + plugin.getName());
    }

    private void instantiate(Class<?> plugin) {
        try {
            addObject((Plugin) plugin.getConstructor().newInstance());
        } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            Pipe.log("Failed loading plugin: " + plugin.getName());
        }
    }
}
