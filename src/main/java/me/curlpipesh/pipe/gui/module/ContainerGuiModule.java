package me.curlpipesh.pipe.gui.module;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import me.curlpipesh.pipe.gui.GuiModule;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IContainer;
import me.curlpipesh.pipe.gui.api.model.base.interfaces.IWidget;
import me.curlpipesh.pipe.gui.api.view.render.state.RenderException;
import me.curlpipesh.pipe.gui.api.view.render.theme.ITheme;
import me.curlpipesh.pipe.gui.api.view.render.theme.ThemeManager;
import me.curlpipesh.pipe.util.Helper;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;

/**
 * An implementatino of {@link GuiModule} that allows for simplified usage of
 * the classes in <tt>me.curlpipesh.pipe.gui.api</tt>.
 *
 * @author c
 * @since 5/24/15
 */
public abstract class ContainerGuiModule implements GuiModule {
    /**
     * The {@link IContainer}s that this GuiModule will contain.
     */
    private final List<IContainer> containers = new CopyOnWriteArrayList<>();

    /**
     * The theme for this <tt>module</tt>. This theme is allowed to be
     * <tt>null</tt>; if it is <tt>null</tt>, then the default theme in
     * {@link ThemeManager} will be used.
     */
    @Getter
    @Setter
    private ITheme theme;

    @Override
    public final void init() {
        subInit();
        containers.forEach(IContainer::initialize);
    }

    /**
     * Initialization method intended to be used by subclasses, so as to ensure
     * that containers will always be initialized regardless of whether or not
     * the subclass makes a <tt>super</tt> call to {@link #init()}.
     */
    protected abstract void subInit();

    /**
     * Adds an {@link IContainer} to this <tt>module</tt>.
     *
     * @param container The <tt>IContainer</tt> to be added.
     */
    public final void addContainer(IContainer container) {
        if(!containers.contains(container)) {
            containers.add(container);
        }
    }

    @Override
    public final void render(int mx, int my, float ptt) {
        containers.stream().collect(inReverse()).stream().filter(IWidget::isVisible).sequential()
                .forEach(container -> {
                    container.tick();
                    try {
                        if(theme == null) {
                            ThemeManager.getTheme().renderContainer(container);
                        } else {
                            theme.renderContainer(container);
                        }
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

    /**
     * Moves the supplied container to the first position in the list
     *
     * @param thing The container to move
     */
    private void moveToFrontOfList(final IContainer thing) {
        containers.remove(thing);
        containers.add(0, thing);
    }

    /**
     * Return <tt>true</tt> if the supplied {@link IContainer} is at the front
     * of the list of containers, <tt>false</tt> otherwise.
     *
     * @param thing The <tt>container</tt> to check
     * @return <tt>true</tt> if the container is at the front, <tt>false</tt>
     *         otherwise
     */
    public final boolean isInFrontOfList(final IContainer thing) {
        return containers.contains(thing) && containers.indexOf(thing) == 0;
    }


    /**
     * Creates a new {@link Collector} that reverse the order of a list.
     *
     * @param <T> The type parameter of the list
     * @return A new <tt>Collector</tt> that reverses the list's order
     */
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
