package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.event.Render3D;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.Renderer;
import me.curlpipesh.pipe.util.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
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
                    for(Object o : Helper.getLoadedEntities()) {
                        Vec3 p = Helper.getEntityVec(Helper.getPlayer());
                        Vec3 pos = Helper.getEntityVec(o);
                        pos.sub(p);
                        if(pos != null) {
                            System.out.println(pos);
                            //Renderer.drawLine(0, 0, 0, pos.x(), pos.y(), pos.z(), 0xFFFFFF00);
                            GL11.glDisable(GL11.GL_CULL_FACE);
                            Renderer.drawBox(pos.x(), pos.y(), pos.z(), 1, 1, 1, 0x77FF00FF);
                            GL11.glEnable(GL11.GL_CULL_FACE);
                            ++count;
                        }
                    }
                    setStatus(count > 0 ? Status.OK : Status.NOT_RENDERING);
                }
            }
        });
    }

    @Override
    public boolean isStatusShown() {
        return true;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
