package me.curlpipesh.pipe.mods;

import lombok.Getter;
import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.plugin.impl.ExecutablePlugin;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.lib.util.Toggleable;
import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.gui.api.controller.action.MouseClickAction;
import me.curlpipesh.pipe.gui.api.controller.action.TickAction;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.impl.BasicWidget;
import me.curlpipesh.pipe.gui.api.model.impl.BasicWindow;
import me.curlpipesh.pipe.gui.api.view.layout.impl.TwoColumnLayout;
import me.curlpipesh.pipe.gui.module.ContainerGuiModule;
import me.curlpipesh.pipe.gui.theme.PipeTheme;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

/**
 * Plugin that displays a GUI
 *
 * @author c
 * @since 5/24/15
 */
@Load(priority = LoadPriority.INIT_AFTER_ALL)
public class PluginGui extends ExecutablePlugin {
    /**
     * The {@link GuiModule} that is going to be displayed
     */
    @Getter
    private GuiModule module;

    @Override
    public void init() {
        setName("Gui");
        setKey(Keyboard.KEY_Y);
        module = new ContainerGuiModule() {
            @Override
            public void init() {
                if(getContainers().isEmpty()) {
                    setTheme(new PipeTheme());
                    IContainer toggleContainer = new BasicWindow("Toggle");
                    IContainer exeContainer = new BasicWindow("Exe");
                    PluginManager.getInstance().getManagedObjects().forEach(p -> {
                        BasicWidget btn = new BasicWidget("button", p.getName());
                        if(p instanceof Toggleable) {
                            btn.addAction((MouseClickAction<BasicWidget>) (component, button) -> {
                                ((Toggleable) p).toggle();
                                component.setState(((Toggleable) p).isEnabled());
                            });
                            btn.addAction((TickAction) component -> component.setState(((Toggleable)p).isEnabled()));
                            toggleContainer.addChild(btn);
                        } else if(p instanceof ExecutablePlugin) {
                            btn.addAction((MouseClickAction<BasicWidget>) (component, button) -> ((ExecutablePlugin) p).execute());
                            btn.addAction((TickAction) component -> btn.setState(false));
                            exeContainer.addChild(btn);
                        }
                    });
                    exeContainer.setLayout(new TwoColumnLayout());
                    addContainer(exeContainer);
                    addContainer(toggleContainer);
                    getContainers().forEach(IContainer::tick);
                }
            }

            @Override
            public boolean isPauseGame() {
                return false;
            }
        };
    }

    @Override
    public void execute() {
        Helper.displayGuiModule(module);
    }
}
