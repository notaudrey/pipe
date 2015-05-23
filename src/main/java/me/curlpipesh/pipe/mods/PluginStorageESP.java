package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.impl.BasePlugin;
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
 * @since 5/23/15
 */
public class PluginStorageESP extends BasePlugin {
    @Override
    public void init() {
        setName("Storage ESP");
        setKey(Keyboard.KEY_C);
        EventManager.register(new Listener<Render3D>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void event(Render3D render3D) {
                if(PluginStorageESP.this.isEnabled()) {
                    Renderer.pre();
                    GL11.glDisable(GL11.GL_DEPTH_TEST);
                    Helper.disableLightmap();
                    Vec3 p = Helper.getEntityVec(Helper.getPlayer());
                    Helper.getLoadedBlockEntities().stream().filter(Helper::isBlockEntityChest).forEach(o -> {
                        Vec3 v = Helper.getBlockEntityVec(o);
                        Vec3 v2 = Helper.getBlockEntityVec(o).add(Vec3.unit());
                        if(v != null) {
                            v.sub(p);
                            v2.sub(p);
                            Renderer.drawBoxFromPoints(v, v2, 0x7700FFFF);
                        }
                    });
                    Helper.enableLightmap();
                    GL11.glEnable(GL11.GL_DEPTH_TEST);
                    Renderer.post();
                }
            }
        });
    }

    @Override
    public boolean isStatusShown() {
        return true;
    }
}
