package network.mainbungeecord.mainbungeecord.listener.chatmessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ChatMessage implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(ChatEvent e) {
        if(!e.isCommand() && !e.isProxyCommand()) {
            e.setCancelled(true);
            ProxiedPlayer player = (ProxiedPlayer) e.getSender();
            if(player != null) {
                ServerInfo server = player.getServer().getInfo();

                for(ProxiedPlayer target : server.getPlayers()) {
                    target.sendMessage(new TextComponent(ChatColor.RED + "[" + e.getSender() + "]" + ChatColor.RESET +  ": " + e.getMessage()));
                }
            }
        }
    }
}