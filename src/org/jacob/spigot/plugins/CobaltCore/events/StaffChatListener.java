package org.jacob.spigot.plugins.CobaltCore.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(e.getMessage().startsWith("!")) {
            e.setCancelled(true);

            for(Player pl : Bukkit.getOnlinePlayers()) {

                if(p.hasPermission("cc.staffchat.listener")) {
                    if(pl.hasPermission("cc.staffchat.listener")) {
                        pl.sendMessage(ChatColor.RED + "[StaffChat] " + ChatColor.DARK_GREEN + p.getName() + ChatColor.DARK_GRAY + ": " + ChatColor.AQUA + e.getMessage().substring(1));
                    }
                } else {
                    return;
                }
            }
        }

    }
}
