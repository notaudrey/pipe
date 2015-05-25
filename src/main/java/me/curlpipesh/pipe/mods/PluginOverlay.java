package me.curlpipesh.pipe.mods;

import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.PluginManager;
import me.curlpipesh.lib.util.Toggleable;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.event.Render2D;
import me.curlpipesh.pipe.util.Helper;
import me.curlpipesh.pipe.util.GLRenderer;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * Renders an informative overlay on the in-game GUI.
 *
 * @author c
 * @since 5/15/15
 */
public class PluginOverlay implements Plugin {
    /**
     * Offset for active plugin name/information rendering
     */
    private final int OFFSET = Helper.getFontHeight() + 2;

    @Override
    public void init() {
        EventManager.register(new Listener<Render2D>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void event(Render2D render2D) {
                int yOffset = OFFSET + 2;
                int count = 1;
                final String status = String.format("§bPipe! §r(Status: §a%s§r)", Pipe.getInstance().getStatus());
                int width = Helper.getStringWidth(status);
                if(!Helper.isWorldNull() && !Helper.isIngameGuiInDebugMode()) {
                    for(Plugin p : PluginManager.getInstance().getManagedObjects()) {
                        if(p instanceof Toggleable) {
                            if(((Toggleable) p).isEnabled()) {
                                String format = p.isStatusShown() ?
                                        "§a%s §r(§f%s§r)" :
                                        "§a%s";
                                int w = p.isStatusShown() ?
                                        Helper.getStringWidth(String.format(format, p.getName(), p.getStatus())) :
                                        Helper.getStringWidth(String.format(format, p.getName()));
                                ++count;
                                if(w > width) {
                                    width = w;
                                }
                            }
                        }
                    }
                    GLRenderer.drawRect(0, 0, width + 4, OFFSET * count, 0x77000000);
                    Helper.drawString(status, 2, 2, 0xFFFFFFFF, false);
                    for(Plugin p : PluginManager.getInstance().getManagedObjects()) {
                        if(p instanceof Toggleable) {
                            if(((Toggleable) p).isEnabled()) {
                                if(p.isStatusShown()) {
                                    String format = p.isStatusShown() ?
                                            "§a%s §r(§f%s§r)" :
                                            "§a%s";
                                    String s = p.isStatusShown() ?
                                            String.format(format, p.getName(), p.getStatus()) :
                                            String.format(format, p.getName());
                                    Helper.drawString(s, 2, yOffset, 0xFFFFFFFF, false);
                                    yOffset += OFFSET;
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public String getStatus() {
        return "";
    }

    @Override
    public void setStatus(String status) {
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {
    }
}
