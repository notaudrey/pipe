package me.curlpipesh.pipe.gui.module;

import com.google.common.collect.Lists;
import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IWidget;
import me.curlpipesh.pipe.gui.api.view.render.state.RenderException;
import me.curlpipesh.pipe.gui.api.view.render.theme.ThemeManager;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;

/**
 * @author audrey
 * @since 5/24/15
 */
public abstract class ContainerGuiModule implements GuiModule {
    private final List<IContainer> containers = new CopyOnWriteArrayList<>();

    @Override
    public final void init() {
        subInit();
        containers.forEach(IContainer::initialize);
    }

    protected abstract void subInit();

    public final void addContainer(IContainer container) {
        if(!containers.contains(container)) {
            containers.add(container);
        }
    }

    @Override
    public final void render(int mx, int my, float ptt) {
        containers.parallelStream().collect(inReverse()).parallelStream().filter(IWidget::isVisible).sequential()
                .forEach(container -> {
                    container.tick();
                    try {
                        ThemeManager.getTheme().render(container);
                    } catch (RenderException e) {
                        e.printStackTrace();
                    }
                });

    }

    @Override
    public final void keypress(char c, int k) {
        if(k == Keyboard.KEY_ESCAPE) {
            Helper.displayGuiScreen(null);
        }
    }

    @Override
    public final void mouseDown(int mx, int my, int mb) {
        for(IContainer e : containers) {
            if(e.isMouseOver()) {
                if(!isInFrontOfList(e)) {
                    moveToFrontOfList(e);
                }
                e.click(mb);
                return;
            }
        }

    }

    @Override
    public final void mouseDownMove(int mx, int my, int mb, long t) {
        containers.parallelStream().filter(c -> c.isVisible() && c.isFocused()).sequential()
                .forEach(c -> c.drag(mb));
    }

    @Override
    public final void mouseUp(int mx, int my, int mb) {
        containers.parallelStream().filter(c -> c.isVisible() && c.isFocused()).sequential()
                .forEach(c -> c.release(mb));

    }

    private void moveToFrontOfList(final IContainer thing) {
        containers.remove(thing);
        containers.add(0, thing);
    }

    public final boolean isInFrontOfList(final IContainer thing) {
        return containers.contains(thing) && containers.indexOf(thing) == 0;
    }


    @SuppressWarnings("unchecked")
    private <T> Collector<T, List<T>, List<T>> inReverse() {
        return Collector.of(
                ArrayList::new,
                List::add,
                (l, r) -> {
                    l.addAll(r);
                    return l;
                },
                Lists::<T>reverse);
    }
}
