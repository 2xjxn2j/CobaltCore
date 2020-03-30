package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("nether")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
                return true;

            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.worlds.nether")) {
                p.sendMessage(ChatColor.RED + "You do not have permission to go to this world!");
                return true;
            }

            if(p.getWorld().equals("world_nether")) {
                p.sendMessage(ChatColor.RED + "You're already in the nether!");
                return true;
            }

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " world_nether");
            p.sendMessage(ChatColor.GRAY + "Teleported to " + ChatColor.AQUA + " Nether");
            return true;

        }

        if(s.equalsIgnoreCase("world")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
                return true;

            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.worlds.world")) {
                p.sendMessage(ChatColor.RED + "You do not have permission to go to this world!");
                return true;
            }

            if(p.getWorld().equals("world")) {
                p.sendMessage(ChatColor.RED + "You're already in the world!");
                return true;
            }

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " spawn");
            p.sendMessage(ChatColor.GRAY + "Teleported to " + ChatColor.AQUA + " World");
            return true;

        }
        return true;
    }
}
