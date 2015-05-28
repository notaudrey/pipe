package me.curlpipesh.pipe.mods.command;

import me.curlpipesh.lib.plugin.Plugin;
import me.curlpipesh.lib.plugin.loading.Load;
import me.curlpipesh.lib.plugin.loading.LoadPriority;
import me.curlpipesh.lib.util.Status;
import me.curlpipesh.pipe.Pipe;
import me.curlpipesh.pipe.event.ChatSend;
import pw.aria.event.EventManager;
import pw.aria.event.Listener;

/**
 * @author c
 * @since 5/27/15
 */
@Load(priority = LoadPriority.INIT_AFTER_ALL)
public class PluginCommands implements Plugin {
    private final String prefix = ":";

    @Override
    public void init() {
        EventManager.register(new Listener<ChatSend>() {
            @Override
            public void event(ChatSend chatSend) {
                if(chatSend.getMessage().startsWith(prefix)) {
                    chatSend.setCancelled(true);
                }
                Pipe.log(chatSend.getMessage());
            }
        });
    }

    @Override
    public String getName() {
        return "Commands";
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public String getStatus() {
        return Status.OK;
    }

    @Override
    public void setStatus(String status) {
    }

    @Override
    public boolean isStatusShown() {
        return false;
    }
}
