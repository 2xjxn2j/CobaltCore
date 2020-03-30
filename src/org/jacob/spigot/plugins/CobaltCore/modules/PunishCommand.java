package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jacob.spigot.plugins.CobaltCore.utils.ItemStackBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PunishCommand implements CommandExecutor {

    public static final Map<Player, String> targets = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("punish")) {

            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.punish")) {
                p.sendMessage(ChatColor.RED + "No Permissions!");
                return true;
            }

            if(strings.length != 1) {
                p.sendMessage(ChatColor.RED + "Usage: /punish <player>");
                return true;
            }
            Player t = Bukkit.getPlayerExact(strings[0]);

            Inventory inv = Bukkit.createInventory(null,36, "Punishments");

            targets.put((Player) p, strings[0]);

            inv.setItem(4, new ItemStackBuilder(Material.RED_WOOL)
                    .name(ChatColor.RED + "Ban")
                    .lore(Arrays.asList(
                            ChatColor.YELLOW + "Bans a player"
                    )).build());

            inv.setItem(1, new ItemStackBuilder(Material.PAPER)
                    .name(ChatColor.RED + "Kick")
                    .lore(Arrays.asList(
                            ChatColor.YELLOW + "Kicks a player"
                    )).build());

            p.openInventory(inv);

            return true;
        }

        return true;
    }
}
