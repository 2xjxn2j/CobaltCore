package org.jacob.spigot.plugins.CobaltCore.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class PlayerDataJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        FileConfiguration data = Main.getInstance().getPlayerData();

        if(!data.contains("players." + p.getUniqueId().toString())) {
            data.set("players." + p.getUniqueId().toString() + ".name", p.getName());
            data.set("players." + p.getUniqueId().toString() + ".rank", p.getDisplayName());
            data.set("players." + p.getUniqueId().toString() + ".operator", p.isOp());
            Main.getInstance().savePlayerData();
        }
    }

}
