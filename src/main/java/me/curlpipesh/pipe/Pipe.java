package me.curlpipesh.pipe;

import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.util.Statused;
import me.curlpipesh.pipe.util.Constants;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.HelperGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author audrey
 * @since 4/30/15
 */
public class Pipe implements Statused {
    private static Pipe instance;

    private Pipe() {
        log("Starting up Pipe...");
    }

    @SuppressWarnings("unused")
    public void init() {
        generateHelper();
        PluginManager.getInstance().init();
    }

    public static Pipe getInstance() {
        return instance == null ? instance = new Pipe() : instance;
    }

    public static void log(String... messages) {
        for(String e : messages) {
            System.out.println("> " + e);
        }
    }

    private void generateHelper() {
        try {
            byte[] gen = HelperGenerator.generate();
            Method define = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
            define.setAccessible(true);
            define.invoke(Pipe.class.getClassLoader(), "me.curlpipesh.pipe.util.Helper", gen, 0, gen.length);
        } catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getStatus() {
        String clientModName;
        try {
            clientModName = (String) Class.forName("net.minecraft.client.ClientBrandRetriever")
                    .getDeclaredMethod("getClientModName").invoke(null);
        } catch(IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        if(!clientModName.equals("vanilla")) {
            return "Modded (" + clientModName + ")"; // "Definitely; Client brand changed to '" + clientModName + "'";
        }
        if(Constants.MINECRAFTCLASS.getSigners() == null) {
            return "Invalid JAR sig."; // "Very likely; Jar signature invalidated";
        }
        return "Clean"; // "Probably not. Jar signature remains and client brand is untouched.";
    }

    @Override
    public void setStatus(String status) {
        throw new RuntimeException("Don't do that.");
    }

    @Override
    public boolean isStatusShown() {
        return true;
    }
}
