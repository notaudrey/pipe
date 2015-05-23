package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.event.Render3D;
import me.curlpipesh.pipe.util.Constants;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.Renderer;
import me.curlpipesh.pipe.util.Vec3;
import org.lwjgl.input.Keyboard;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * @author audrey
 * @since 5/21/15
 */
public class PluginTracers extends BasePlugin {
    @Override
    public void init() {
        setKey(Keyboard.KEY_R);
        setName("Tracers");
        EventManager.register(new Listener<Render3D>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void event(Render3D render3D) {
                if(PluginTracers.this.isEnabled()) {
                    int count = 0;
                    Vec3 p = Helper.getEntityVec(Helper.getPlayer());
                    for(Object o : Helper.getLoadedEntities()) {
                        if(!o.equals(Helper.getPlayer())) {
                            if(Constants.getByName("EntityLiving").getClazz().isAssignableFrom(
                                            Constants.getByName("Entity").getClazz().cast(o).getClass())) {
                                Vec3 e = Helper.getEntityVec(o);
                                if(e != null) {
                                    e.sub(p);
                                    Renderer.drawLine(Vec3.zero().addY(1.0D), e, 0xFFFF0000, 2.235F);
                                    ++count;
                                }
                            }
                        }
                    }
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
