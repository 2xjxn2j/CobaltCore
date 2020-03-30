package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("discord")) {

            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only player can execute this command!");
                return true;
            }

            Player p = (Player) commandSender;

            p.sendMessage(ChatColor.GREEN + "You can join our discord here! " + ChatColor.YELLOW + "https://discord.gg/8NTkYEZ");
            return true;

        }
        return true;
    }
}
