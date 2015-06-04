package me.curlpipesh.pipe.gui.module;

import me.curlpipesh.pipe.gui.api.controller.action.MouseClickAction;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IWidget;
import me.curlpipesh.pipe.gui.api.model.impl.BasicContainer;
import me.curlpipesh.pipe.gui.api.model.impl.BasicWidget;
import me.curlpipesh.pipe.gui.api.view.layout.impl.StandardLayout;
import me.curlpipesh.pipe.gui.theme.MainMenuTheme;

import java.util.stream.IntStream;

/**
 * @author c
 * @since 6/3/15
 */
public class GuiModuleMainMenu extends ContainerGuiModule {
    @Override
    public void init() {
        setTheme(new MainMenuTheme());

        IContainer container = new BasicContainer("Ye Olde Menu");
        IWidget btn = new BasicWidget("button", "Exit");
        btn.addAction((MouseClickAction) (component, button) -> System.exit(0));
        container.addChild(btn);
        IntStream.range(0, 10).forEach(i -> container.addChild(new BasicWidget("button", "Button Number " + i)));
        container.setLayout(new StandardLayout(128, 16));
        addContainer(container);
    }

    @Override
    public boolean isPauseGame() {
        return true;
    }
}
