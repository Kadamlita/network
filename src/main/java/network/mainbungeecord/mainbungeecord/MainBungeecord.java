package network.mainbungeecord.mainbungeecord;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import network.mainbungeecord.mainbungeecord.commands.ping.Ping;
import network.mainbungeecord.mainbungeecord.listener.chatmessage.ChatMessage;

public final class MainBungeecord extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Ping("ping"));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new ChatMessage());
    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic
    }
}
