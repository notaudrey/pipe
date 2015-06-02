package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.config.option.ColorOption;
import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.event.Render3D;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.GLRenderer;
import me.curlpipesh.pipe.util.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * Draws lines from the player to other entities in the world. Presently very
 * ugly.
 *
 * @author c
 * @since 5/21/15
 */
public class PluginTracers extends BasePlugin {
    private final Vec3 offset = new Vec3(0, 1.62D, 0);

    private ColorOption color = new ColorOption("color", 0xFFFFFFFF),
            animal = new ColorOption("animalColor", 0xFF00FF00),
            monster = new ColorOption("monsterColor", 0xFFFF0000);

    @Override
    public void init() {
        setKey(Keyboard.KEY_R);
        setName("Tracers");
        addOption(color);
        addOption(animal);
        addOption(monster);
        EventManager.register(new Listener<Render3D>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void event(Render3D render3D) {
                if(PluginTracers.this.isEnabled()) {
                    offset.y(Helper.isEntitySneaking(Helper.getPlayer()) ? 1.54D : 1.62D);
                    int count = 0;
                    Vec3 p = Helper.getEntityVec(Helper.getPlayer());
                    GLRenderer.pre();
                    GL11.glDisable(GL11.GL_DEPTH_TEST);
                    for(Object o : Helper.getLoadedEntities()) {
                        if(!o.equals(Helper.getPlayer())) {
                            if(Helper.isEntityLiving(o)) {
                                Vec3 e = Helper.getEntityVec(o);
                                if(e != null) {
                                    e.sub(p);
                                    GLRenderer.drawLine(offset, e,
                                            Helper.isEntityAnimal(o) ? animal.get() :
                                                    Helper.isEntityMonster(o) ? monster.get() : color.get(), 2.235F);
                                    ++count;
                                }
                            }
                        }
                    }
                    GL11.glEnable(GL11.GL_DEPTH_TEST);
                    GLRenderer.post();
                    setStatus(count > 0 ? Status.OK + " §r(§a" + count + "§r)" : Status.NOT_RENDERING);
                }
            }
        });
    }

    @Override
    public boolean isStatusShown() {
        return true;
    }
}
