package me.curlpipesh.lib.config;

import lombok.Getter;
import lombok.Setter;
import me.curlpipesh.pipe.Pipe;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Simple implementation of the <tt>Configurable</tt> interface. Presently
 * unused.
 *
 * TODO Add in saving/loading
 *
 * @author c
 * @since 5/23/15
 */
public class BasicConfigurable implements Configurable {
    @Getter
    private final List<Option<?>> options = new CopyOnWriteArrayList<>();

    @Getter
    @Setter
    private File file;

    @Override
    public void load() {
        if(file != null) {
            // Load stuff properly
        }
    }

    @Override
    public void save() {

    }

    @Override
    public void addOption(Option<?> option) {
        if(!options.contains(option)) {
            if(options.stream().filter(o -> o.name().equals(option.name())).count() == 0) {
                options.add(option);
            } else {
                Pipe.log("Attempted to add an option with the name " + option.name() + ", but an option with that name already exists!");
            }
        } else {
            Pipe.log("Attempted to add the option \"" + option.name() + "\" twice!");
        }
    }

    @Override
    public void removeOption(Option<?> option) {
        if(options.contains(option)) {
            if(!options.remove(option)) {
                Pipe.log("Failed to remove option: \"" + option.name() + "\"");
            }
        }
    }

    @Override
    public Optional<Option<?>> getOptionByName(String name) {
        return options.stream().filter(o -> o.name().equalsIgnoreCase(name)).findFirst();
    }
}
