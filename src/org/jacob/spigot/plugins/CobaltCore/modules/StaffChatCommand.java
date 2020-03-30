package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("sc")) {

            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.staffchat")) {
                p.sendMessage(ChatColor.RED + "No permissions!");
                return true;

            }

            if(strings.length == 0) {
                p.sendMessage(ChatColor.RED + "Usage: /sc <message> or !<message>");
                return true;
            }

            for(Player e : Bukkit.getOnlinePlayers()) {

                String message = "";
                for (int i = 0; i < strings.length; i++) {
                    message = message + strings[i] + " ";
                }

                if(e.hasPermission("cc.staffchat.listener")) {
                    e.sendMessage(ChatColor.RED + "[StaffChat] " + ChatColor.DARK_GREEN + p.getName() + ChatColor.DARK_GRAY + ": " + ChatColor.AQUA + message);

                } else {
                    return true;
                }
            }
        }
        return true;
    }

}
