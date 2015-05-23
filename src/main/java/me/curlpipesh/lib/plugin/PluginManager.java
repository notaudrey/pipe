package me.curlpipesh.lib.plugin;

import lombok.Getter;
import me.curlpipesh.bytecodetools.util.ClassEnumerator;
import me.curlpipesh.lib.manager.AbstractManager;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.lib.annotations.Disabled;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author audrey
 * @since 5/9/15
 */
public class PluginManager extends AbstractManager<Plugin> {
    @Getter
    private static final PluginManager instance = new PluginManager();

    private PluginManager() {
    }

    @Override
    public void init() {
        Pipe.log("Loading plugins...");
        Class<?>[] classes = ClassEnumerator.getClassesFromJar(new File(Pipe.class.getProtectionDomain().getCodeSource().getLocation().getFile()), Pipe.class.getClassLoader()).stream().toArray(Class<?>[]::new);
        Arrays.stream(classes).filter(Plugin.class::isAssignableFrom).filter(c -> c.getName().contains("me.curlpipesh.pipe.mods"))
                .filter(c -> !c.isAnnotationPresent(Disabled.class)).forEach(c -> {
            try {
                addObject((Plugin) c.getConstructor().newInstance());
            } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("> " + c.getName());
                e.printStackTrace();
            }
        });
        getManagedObjects().forEach(Plugin::init);
        Pipe.log(getManagedObjects().size() + " plugins loaded!");
    }
}
