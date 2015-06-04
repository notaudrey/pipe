package me.curlpipesh.pipe.gui.module;

import me.curlpipesh.pipe.gui.api.controller.action.MouseClickAction;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IWidget;
import me.curlpipesh.pipe.gui.api.model.impl.BasicContainer;
import me.curlpipesh.pipe.gui.api.model.impl.BasicWidget;
import me.curlpipesh.pipe.gui.api.view.layout.impl.StandardLayout;
import me.curlpipesh.pipe.gui.theme.MainMenuTheme;
import me.curlpipesh.pipe.util.GLRenderer;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.opengl.Display;

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
        IWidget btn = new BasicWidget("button", "Exit");
        btn.addAction((MouseClickAction) (component, button) -> System.exit(0));
        container.addChild(btn);
        IntStream.range(0, 10).forEach(i -> container.addChild(new BasicWidget("button", "Button Number " + i)));
        container.setLayout(new StandardLayout(128, 16));
        addContainer(container);
        IntStream.range(0, 256).forEach(i -> snowflakes.add(new Snowflake(random.nextDouble() * (Display.getWidth() / Helper.getScale()),
                        random.nextDouble() * 4D)));
    }

    @Override
    protected void midrender() {
        GLRenderer.pre();
        for(Snowflake snowflake : snowflakes) {
            snowflake.x += (random.nextDouble() * 2) * (Math.random() > 0.5 ? -1 : 1);
            snowflake.y += (random.nextDouble() * 3);
            if(snowflake.y >= Display.getHeight() / Helper.getScale()) {
                snowflake.y = 0;
            }
            GLRenderer.drawCircle(snowflake.x, snowflake.y, snowflake.r, 0x34FFFFFF);
        }
        GLRenderer.post();
    }

    @Override
    public boolean isPauseGame() {
        return true;
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
