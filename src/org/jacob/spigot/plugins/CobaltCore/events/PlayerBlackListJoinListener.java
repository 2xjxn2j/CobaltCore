package org.jacob.spigot.plugins.CobaltCore.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class PlayerBlackListJoinListener implements Listener {

    FileConfiguration data = Main.getInstance().getPlayerData();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        if(data.getBoolean("options.blacklist")) {
            if(!p.hasPermission("cc.blacklist.immune")) {
                p.kickPlayer(ChatColor.RED + "Sorry, the server is currently " + ChatColor.DARK_RED + "Blacklisted");
                return;
            }
            return;
        }
        return;
    }
}
