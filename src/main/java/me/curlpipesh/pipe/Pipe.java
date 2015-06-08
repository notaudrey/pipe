package me.curlpipesh.pipe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.curlpipesh.bytecodetools.BytecodeTools;
import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.util.Statused;
import me.curlpipesh.pipe.generators.GuiScreenGenerator;
import me.curlpipesh.pipe.gui.module.GuiModuleMainMenu;
import me.curlpipesh.pipe.util.Constants;
import me.curlpipesh.pipe.util.Helper;

import java.lang.reflect.InvocationTargetException;

/**
 * Main class of the client
 *
 * @author c
 * @since 4/30/15
 */
public final class Pipe implements Statused {
    /**
     * Singleton instance of the client
     */
    private static final Pipe instance = new Pipe();

    /**
     * Version of the client. Follows <a href="http://semver.org/">semver</a> rules, at
     * least somewhat
     */
    private static final String semver = "0.7.0";

    private final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    private Pipe() {}

    /**
     * Initializes the client. This method is called from code injected into
     * the game's main class
     */
    @SuppressWarnings("unused")
    public void init() {
        log("Starting up Pipe...");
        BytecodeTools.defineClass(Pipe.class.getClassLoader(), GuiScreenGenerator.generate(), "me.curlpipesh.pipe.gui.GuiScreen");
        PluginManager.getInstance().init();
        log("Displaying new GUI...");
        Helper.displayGuiModule(new GuiModuleMainMenu());
        log("Done!");
    }

    /**
     * Returns the singleton instance of the client.
     *
     * @return The singleton instance of the client
     */
    public static Pipe getInstance() {
        return instance;
    }

    /**
     * Logs messages to <tt>stdout</tt>
     *
     * @param messages The messages to be logged
     */
    public static void log(String... messages) {
        for(String e : messages) {
            System.out.println("> " + e);
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
        if(Constants.getByName("Minecraft").getClazz().getSigners() == null) {
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

    /**
     * Returns the semver number of the client
     *
     * @return The semver number of the client
     */
    public static String getVersion() {
        return semver;
    }
}
