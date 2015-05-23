package me.curlpipesh.pipe.util;

import lombok.Data;

/**
 * Simple representation of an obfuscated class
 *
 * @author audrey
 * @since 5/22/15
 */
@Data
public class ObfusClass {
    private final String realName;
    private final String name;
    private final String desc;
    private final Class<?> clazz;

    public ObfusClass(String name, String obfName) {
        this.realName = name;
        this.name = obfName;
        this.desc = "L" + obfName + ";";
        try {
            clazz = Class.forName(obfName);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
