package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("cobaltcore")) {

            if(!(commandSender instanceof Player)) {
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.info")) {
                p.sendMessage(ChatColor.RED + "No permissions!");
                return true;
            }

            if(strings.length == 0) {
                p.sendMessage(ChatColor.WHITE + "CobaltCore, a plugin created by 2xjtn.");
                p.sendMessage(ChatColor.RED + "/cobaltcore reload " + ChatColor.GOLD + "Reloads the plugin.");
                return true;
            }

            if(strings.length == 1) {

                if(!strings[0].equalsIgnoreCase("reload")) {
                    return true;
                }

                if(strings[0].equalsIgnoreCase("reload")) {
                    p.sendMessage(ChatColor.GREEN + "CobaltCore has successfully reloaded!");
                    Main.getInstance().reloadConfig();
                    return true;
                }
            }

        }

        return true;
    }
}
