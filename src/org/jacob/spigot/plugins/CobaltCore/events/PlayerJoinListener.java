package org.jacob.spigot.plugins.CobaltCore.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class PlayerJoinListener implements Listener {

    FileConfiguration data = Main.getInstance().getPlayerData();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!data.getBoolean("options.blacklist")) {
            e.setJoinMessage("");
            Bukkit.broadcastMessage(ChatColor.GREEN + "+ " + ChatColor.GRAY + e.getPlayer().getName());
            return;
        } else {
            if (e.getPlayer().hasPermission("cc.blacklist.immune")) {
                e.setJoinMessage("");
                Bukkit.broadcastMessage(ChatColor.GREEN + "+ " + ChatColor.GRAY + e.getPlayer().getName());
                return;
            } else {
                e.setJoinMessage("");
            }
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        if (!data.getBoolean("options.blacklist")) {
            e.setQuitMessage("");
            Bukkit.broadcastMessage(ChatColor.RED + "- " + ChatColor.GRAY + e.getPlayer().getName());
            return;
        } else {
            if (e.getPlayer().hasPermission("cc.blacklist.immune")) {
                e.setQuitMessage("");
                Bukkit.broadcastMessage(ChatColor.RED + "- " + ChatColor.GRAY + e.getPlayer().getName());
                return;
            } else {
                e.setQuitMessage("");
            }
        }
    }
}
