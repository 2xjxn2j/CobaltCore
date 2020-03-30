package org.jacob.spigot.plugins.CobaltCore.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jacob.spigot.plugins.CobaltCore.modules.PunishCommand;

public class InventoryDataListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equals("Punishments")) {

            Player p = (Player) e.getWhoClicked();
            String f = PunishCommand.targets.get((Player) e.getWhoClicked());

            Player t = Bukkit.getPlayer(f);

            int slot = e.getSlot();

            if(t == null) {
                return;
            }

            if(slot == 1) {

                t.kickPlayer(ChatColor.RED + "Youve been kicked!");
                p.sendMessage(ChatColor.GREEN + "Successfully kicked " + ChatColor.YELLOW + t.getName());
                p.closeInventory();
                return;

            } else if (slot == 4){

                t.kickPlayer(ChatColor.RED + "Youve been banned for 1 minute!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + t.getName() + " 1m");
                p.sendMessage(ChatColor.GREEN + "Successfully banned " + ChatColor.YELLOW + t.getName());
                p.closeInventory();
                return;
            }
            e.setCancelled(true);
        }
    }
}
