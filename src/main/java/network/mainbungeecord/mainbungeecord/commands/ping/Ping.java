package network.mainbungeecord.mainbungeecord.commands.ping;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.protocol.packet.Chat;

public class Ping extends Command {
    public Ping(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = null;

        if(sender instanceof ProxiedPlayer) {
           player = (ProxiedPlayer) sender;
           if(player != null && !player.hasPermission("network.ping")) {
               player.sendMessage(new TextComponent("Get perms L"));
               return;
           }
        }

        int ping;

        if(args.length == 0 && !(player == null)){
           ping = player.getPing();
           player.sendMessage(new TextComponent("yuor ping is " + ChatColor.RESET + (ping >= 150 ? ChatColor.RED : (ping <= 80 ? ChatColor.GREEN : ChatColor.GOLD)) + ping ));
        }
        else if(args.length == 1){
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if(target != null){
               ping = target.getPing();
               player.sendMessage(new TextComponent(target.getDisplayName() + " pign is " + ChatColor.RESET + (ping >= 150 ? ChatColor.RED : (ping <= 80 ? ChatColor.GREEN : ChatColor.GOLD)) + ping ));
            }
            else{
                player.sendMessage(new TextComponent("no work"));
            }
        }
        else if(args.length >= 2){
            player.sendMessage(new TextComponent("too many arg ! !!!"));
        }
        else if(args.length == 0){
            System.out.println("Cannot ping console, specify player");
        }
    }
}