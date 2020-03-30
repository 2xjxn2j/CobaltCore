package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceAnnouncementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("forceannounce")) {

            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only player can execute this command.");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.forceannouncement")) {
                p.sendMessage(ChatColor.RED + "No permissions!");
                return true;

            }

            if(strings.length == 0) {
                p.sendMessage(ChatColor.RED + "Usage: /forceannouncement <donation:store:discord>");
                return true;
            }

            if(strings[0].equalsIgnoreCase("donation")) {
                p.sendMessage(ChatColor.GREEN + "Successfully displayed announcement!");
                Bukkit.broadcastMessage(ChatColor.GRAY + "Feel free to donate to our store! " + ChatColor.AQUA + "https://cobaltcraftmc.buycraft.net");
                return true;
            }

            if(strings[0].equalsIgnoreCase("website")) {
                p.sendMessage(ChatColor.GREEN + "Successfully displayed announcement!");
                Bukkit.broadcastMessage(ChatColor.GRAY + "We have a website! Check it out at " + ChatColor.AQUA + "https://cobaltcraft.com");
                return true;
            }

            if(strings[0].equalsIgnoreCase("discord")) {
                p.sendMessage(ChatColor.GREEN + "Successfully displayed announcement!");
                Bukkit.broadcastMessage(ChatColor.GRAY + "Check out our discord!" + ChatColor.AQUA + " https://discord.gg/8NTkYEZ");
                return true;
            }

        }
        return true;
    }
}
