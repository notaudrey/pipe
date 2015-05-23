package me.curlpipesh.lib.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author audrey
 * @since 5/23/15
 */
public class Keybind {
    @Getter
    @Setter
    private int key;
    private final List<Integer> modifiers = new ArrayList<>();

    public Keybind(int key, int... mods) {
        this.key = key;
        for(int mod : mods) {
            modifiers.add(mod);
        }
    }

    public void addModifier(int mod) {
        if(!modifiers.contains(mod)) {
            modifiers.add(mod);
        }
    }

    public void removeModifier(int mod) {
        if(modifiers.contains(mod)) {
            modifiers.remove(mod);
        }
    }

    public Integer[] getModifiers() {
        return modifiers.stream().toArray(Integer[]::new);
    }
}
