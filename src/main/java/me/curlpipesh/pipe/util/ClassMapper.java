package me.curlpipesh.pipe.util;

import lombok.Getter;
import me.curlpipesh.bytecodetools.util.ClassEnumerator;
import me.curlpipesh.pipe.Pipe;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Okay, so it's somewhat of a misnomer. Loads all classes from the JAR at the
 * beginning, then stores them in a list, so that multiple other classes can do
 * the same without needing new <tt>Classloaders</tt>, or abusing
 * {@link me.curlpipesh.bytecodetools.util.ClassEnumerator} more, or etc.
 *
 * @author c
 * @since 6/25/15
 */
public class ClassMapper {
    /**
     * Classes that were found and loaded in
     */
    @Getter
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static final List<Class<?>> mappedClasses = new CopyOnWriteArrayList<>();

    private static boolean loaded = false;

    /**
     * Loads all classes from the JAR (again ;_;), and stores them in
     * {@link #mappedClasses}.
     */
    public static void load() {
        if(loaded) {
            Pipe.log("Classes already mapped - skipping!");
            return;
        }
        Pipe.log("Loading and mapping classes...");
        loaded = true;

        Collections.addAll(mappedClasses, ClassEnumerator.getClassesFromJar(
                new File(Pipe.class.getProtectionDomain().getCodeSource().getLocation().getFile()), Pipe.class.getClassLoader())
                .stream().toArray(Class<?>[]::new));
        Pipe.log("Class mapping complete!");
    }
}
