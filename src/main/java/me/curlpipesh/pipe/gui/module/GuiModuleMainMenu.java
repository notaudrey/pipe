package me.curlpipesh.pipe.gui.module;

import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.gui.GuiScreen;
import me.curlpipesh.pipe.gui.api.controller.action.MouseClickAction;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IWidget;
import me.curlpipesh.pipe.gui.api.model.impl.BasicContainer;
import me.curlpipesh.pipe.gui.api.model.impl.BasicWidget;
import me.curlpipesh.pipe.gui.api.util.Tuple;
import me.curlpipesh.pipe.gui.api.view.layout.impl.StandardLayout;
import me.curlpipesh.pipe.gui.theme.MainMenuTheme;
import me.curlpipesh.pipe.util.ArrayHelper;
import me.curlpipesh.pipe.util.Constants;
import me.curlpipesh.pipe.util.GLRenderer;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author c
 * @since 6/3/15
 */
public class GuiModuleMainMenu extends ContainerGuiModule {
    private List<Snowflake> snowflakes;
    private Random random;

    @Override
    public void init() {
        random = new Random();
        snowflakes = new ArrayList<>();

        setTheme(new MainMenuTheme());
        IContainer container = new BasicContainer("Ye Olde Menu");

        container.addChild(new GuiScreenButton(Constants.getByName("GuiSingleplayer").getClazz(), GuiScreen.getInstance(), "Singleplayer"));
        container.addChild(new GuiScreenButton(Constants.getByName("GuiMultiplayer").getClazz(), GuiScreen.getInstance(), "Multiplayer"));
        container.addChild(new GuiScreenButton(Constants.getByName("GuiOptions").getClazz(), GuiScreen.getInstance(), "Options"));
        IWidget btn = new BasicWidget("button", "Exit");
        btn.addAction((MouseClickAction) (component, button) -> System.exit(0));
        container.addChild(btn);

        container.setLayout(new StandardLayout(128, 16));

        addContainer(container);
        IntStream.range(0, 256).forEach(i -> snowflakes.add(new Snowflake(random.nextDouble() * (Display.getWidth() / Helper.getScale()),
                random.nextDouble() * 4D)));
    }

    @Override
    protected void midrender() {
        GLRenderer.drawRect(0, 0, Display.getWidth() / Helper.getScale(), Display.getHeight() / Helper.getScale(), 0xFF000717);
        GLRenderer.drawSideGradientRect(0, 0, Display.getWidth() / Helper.getScale(), Display.getHeight() / Helper.getScale(),
                0xFF000000, 0x0);
        GLRenderer.pre();
        for(Snowflake snowflake : snowflakes) {
            snowflake.x += (random.nextDouble() * 2) * (Math.random() > 0.5 ? -1 : 1);
            snowflake.y += (random.nextDouble() * 1.75D);
            if(snowflake.y >= Display.getHeight() / Helper.getScale()) {
                snowflake.y = 0;
            }
            GLRenderer.drawCircle(snowflake.x, snowflake.y, snowflake.r, 0x34FFFFFF);
        }
        GLRenderer.post();

        String title = "Pipe";
        String version = Pipe.getVersion();
        int scale = 4;

        GL11.glPushMatrix();
        GL11.glTranslated((Display.getWidth() / Helper.getScale()) / 2, (Display.getHeight() / Helper.getScale()) / (scale * 1.5), 0);
        GL11.glScaled(scale, scale, scale);
        Helper.drawString(title, Helper.getStringWidth(title) * -0.5F, 0, 0xFFAAAAAA, false);
        GL11.glScaled(1 / scale, 1 / scale, 1 / scale);
        GL11.glTranslated(-(Display.getWidth() / Helper.getScale()) / 2, -(Display.getHeight() / Helper.getScale()) / scale, 0);
        GL11.glPopMatrix();

        Helper.drawString(version, ((Display.getWidth() / Helper.getScale()) / 2) + Helper.getFontHeight(),
                ((Display.getHeight() / Helper.getScale()) / (scale * 1.5F)) + Helper.getFontHeight() * (scale - 1) + 3,
                0xFFAAAAAA, false);

        Helper.drawString("Minecraft 1.8.7 (Pipe §9" + Pipe.getVersion() + "§r)", 2,
                (Display.getHeight() / Helper.getScale()) - 2 - Helper.getFontHeight(), 0xFFFFFFFF, false);
    }

    @Override
    public boolean isPauseGame() {
        return true;
    }

    /**
     * Note that the way that this class works is a fairly risky method - it
     * relies on the last <tt>GuiModule</tt> that <tt>GuiScreen</tt> had
     * displayed is the one that we want to display. If it isn't, then the
     * whole mechanism falls apart.
     */
    private final class GuiScreenButton extends BasicWidget {
        @SafeVarargs
        @SuppressWarnings("unchecked")
        public GuiScreenButton(Class<?> guiScreen, Object parentScreen, String text, Tuple<String, String>... tags) {
            super("button", text, ArrayHelper.concat(tags, new Tuple[]{new Tuple<>("render-focus", "false")}));
            addAction((MouseClickAction<GuiScreenButton>) (component, button) -> {
                if(guiScreen.equals(Constants.getByName("GuiOptions").getClazz())) {
                    try {
                        Helper.mc_displayGuiScreen(guiScreen
                                .getConstructor(Constants.getByName("GuiScreen").getClazz(), Constants.getByName("GameSettings").getClazz())
                                .newInstance(parentScreen, Helper.getGameSettings()));
                    } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Helper.mc_displayGuiScreen(guiScreen.getConstructor(Constants.getByName("GuiScreen").getClazz()).newInstance(parentScreen));
                    } catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                boolean temp = isFocused();
                setFocused(false);
                setState(false);
                setFocused(temp);
            });
        }
    }

    private final class Snowflake {
        private double x, y, r;

        public Snowflake(double x, double r) {
            this.x = x;
            this.y = random.nextInt(Display.getHeight() / Helper.getScale());
            this.r = r;
        }
    }
}
