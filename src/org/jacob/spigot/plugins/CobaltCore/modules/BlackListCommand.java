package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class BlackListCommand implements CommandExecutor {

    FileConfiguration data = Main.getInstance().getPlayerData();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("blacklist")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.blacklist")) {
                p.sendMessage(ChatColor.RED + " No permissions!");
                return true;
            }

            if(!data.contains("options.blacklist")) {
                data.createSection("options.blacklist");
                Main.getInstance().savePlayerData();
            }

            if(!data.getBoolean("options.blacklist")) {

                data.set("options.blacklist", true);
                Main.getInstance().savePlayerData();

                p.sendMessage(ChatColor.RED + "The server is now Blacklisted!");

                for(Player k : Bukkit.getOnlinePlayers()) {
                    if(!k.hasPermission("cc.blacklist.immune")) {

                        k.kickPlayer(ChatColor.RED + "The server is currently " + ChatColor.DARK_RED + "Blacklisted");
                        return true;
                    }
                }
                return true;
            } else {

                data.set("options.blacklist", false);
                Main.getInstance().savePlayerData();

                p.sendMessage(ChatColor.GREEN + "The server is no longer Blacklisted!");
            }

        }

        return true;
    }
}
