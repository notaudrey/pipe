package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.config.option.ColorOption;
import me.curlpipesh.lib.plugin.impl.BasePlugin;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.event.Render3D;
import me.curlpipesh.pipe.util.GLRenderer;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * Draws a nice box around blocks used for storing items.
 *
 * @author c
 * @since 5/23/15
 */
public class PluginStorageESP extends BasePlugin {
    @Override
    @SuppressWarnings("unchecked")
    public void init() {
        setName("Storage ESP");
        setKey(Keyboard.KEY_C);
        addOption(new ColorOption("espColor", 0x7700FFFF));
        EventManager.register(new Listener<Render3D>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void event(Render3D render3D) {
                if(PluginStorageESP.this.isEnabled()) {
                    int count = 0;
                    GLRenderer.pre();
                    GL11.glDisable(GL11.GL_DEPTH_TEST);
                    Helper.disableLightmap();
                    Vec3 p = Helper.getEntityVec(Helper.getPlayer());
                    for(Object o : Helper.getLoadedBlockEntities()) {
                        if(Helper.isBlockEntityChest(o)) {
                            Vec3 v = Helper.getBlockEntityVec(o);
                            Vec3 v2 = Helper.getBlockEntityVec(o);
                            if(v != null && v2 != null) {
                                v.sub(p);
                                v2.add(Vec3.unit()).sub(p);
                                GLRenderer.drawBoxFromPoints(v, v2, ((ColorOption) getOptionByName("espColor").get()).get());
                                ++count;
                            }
                        }
                    }
                    Helper.enableLightmap();
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
