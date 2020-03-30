package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jacob.spigot.plugins.CobaltCore.Main;

public class LaunchCommand implements CommandExecutor {

    FileConfiguration data = Main.getInstance().getPlayerData();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("launch")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command!");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.launch")) {
                p.sendMessage(ChatColor.RED + "No permissions!");
                return true;
            }

            if(strings.length != 0) {
                p.sendMessage(ChatColor.RED + "No arguments allowed.");
                return true;
            }

            Bukkit.setWhitelist(false);
            data.set("options.blacklist", false);
            Main.getInstance().savePlayerData();

            p.sendMessage(ChatColor.GREEN + "Whitelist and Blacklist have been disabled.");
            p.sendMessage(ChatColor.GREEN + "The server has Launched!");
            return true;

        }

        return true;
    }
}
