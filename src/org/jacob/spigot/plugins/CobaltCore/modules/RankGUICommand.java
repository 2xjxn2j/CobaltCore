package org.jacob.spigot.plugins.CobaltCore.modules;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jacob.spigot.plugins.CobaltCore.Main;
import org.jacob.spigot.plugins.CobaltCore.utils.ItemStackBuilder;
import org.bukkit.event.Listener;

import java.util.Arrays;

public class RankGUICommand implements Listener, CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (s.equalsIgnoreCase("ranks")) {

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command");
                return true;
            }
            Player p = (Player) commandSender;

            if (!p.hasPermission("cc.ranks.gui")) {
                p.sendMessage(ChatColor.RED + "No permissions!");
                return true;
            }

            if (strings.length != 0) {
                p.sendMessage(ChatColor.RED + "No additional arguments required.");
                return true;
            }

            Inventory ranks = Bukkit.createInventory(null, 18, "Rank Upgrades");

            ranks.setItem(0, new ItemStackBuilder(Material.YELLOW_STAINED_GLASS_PANE)
                    .name(ChatColor.YELLOW + "Adventurer Rank")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Upgrade your rank to " + ChatColor.YELLOW + "Adventurer", ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$1,000,000"
                    )).build());


            ranks.setItem(2, new ItemStackBuilder(Material.BLUE_STAINED_GLASS_PANE)
                    .name(ChatColor.BLUE + "Hero Rank")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Upgrade your rank to " + ChatColor.BLUE + "Hero",
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$5,000,000"
                    )).build());

            ranks.setItem(4, new ItemStackBuilder(Material.GREEN_STAINED_GLASS_PANE)
                    .name(ChatColor.GREEN + "Titan Rank")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Upgrade your rank to " + ChatColor.GREEN + "Titan",
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$15,000,000"
                    )).build());

            ranks.setItem(6, new ItemStackBuilder(Material.PURPLE_STAINED_GLASS_PANE)
                    .name(ChatColor.DARK_PURPLE + "Legend Rank")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Upgrade your rank to " + ChatColor.DARK_PURPLE + "Legend",
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$30,000,000"
                    )).build());

            ranks.setItem(8, new ItemStackBuilder(Material.ORANGE_STAINED_GLASS_PANE)
                    .name(ChatColor.GOLD + "Ultimate Rank")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Upgrade your rank to " + ChatColor.GOLD + "Ultimate",
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$100,000,000"
                    )).build());

            p.openInventory(ranks);
        }
        return true;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(e.getView().getTitle().equalsIgnoreCase("Rank Upgrades")) {

            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();

            int slot = e.getSlot();

            if(slot == 0) {

                if(Main.getEconomy().getBalance(p) < 1000000) {
                    p.sendMessage(ChatColor.RED + "You don't have enough money for this rank!");
                    p.closeInventory();
                    return;
                }

                if(!p.hasPermission("cc.rank.adventurer")) {
                    p.sendMessage(ChatColor.RED + "You may not purchase this rank");
                    p.closeInventory();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.GRAY + "Congratulations, " + ChatColor.AQUA + p.getName() + ChatColor.GRAY + " on obtaining "
                        + ChatColor.AQUA + "Adventurer Rank" +
                        ChatColor.GRAY + "!");

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " group set adventurer");
                Main.getInstance().getEconomy().withdrawPlayer(p, 1000000);
                p.sendMessage(ChatColor.GREEN + "Funds have been taken out of your account.");
                p.closeInventory();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.adventurer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.explorer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.hero true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.legend true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.ultimate true");

                e.setCancelled(true);

                return;

            } else if (slot == 2){

                if(Main.getEconomy().getBalance(p) < 5000000) {
                    p.sendMessage(ChatColor.RED + "You don't have enough money for this rank!");
                    p.closeInventory();
                    return;
                }

                if(!p.hasPermission("cc.rank.hero")) {
                    p.sendMessage(ChatColor.RED + "You may not purchase this rank");
                    p.closeInventory();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.GRAY + "Congratulations, " + ChatColor.AQUA + p.getName() + ChatColor.GRAY + " on obtaining "
                        + ChatColor.AQUA + "Hero Rank" +
                        ChatColor.GRAY + "!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " group set hero");
                Main.getInstance().getEconomy().withdrawPlayer(p, 5000000);
                p.sendMessage(ChatColor.GREEN + "Funds have been taken out of your account.");
                p.closeInventory();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.adventurer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.explorer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.hero false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.titan true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.legend true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.ultimate true");

                e.setCancelled(true);

                return;

            } else if (slot == 4){

                if(Main.getEconomy().getBalance(p) < 15000000) {
                    p.sendMessage(ChatColor.RED + "You don't have enough money for this rank!");
                    p.closeInventory();
                    return;
                }

                if(!p.hasPermission("cc.rank.titan")) {
                    p.sendMessage(ChatColor.RED + "You may not purchase this rank");
                    p.closeInventory();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.GRAY + "Congratulations, " + ChatColor.AQUA + p.getName() + ChatColor.GRAY + " on obtaining "
                        + ChatColor.AQUA + "Titan Rank" +
                        ChatColor.GRAY + "!");

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " group set titan");
                Main.getInstance().getEconomy().withdrawPlayer(p, 15000000);
                p.sendMessage(ChatColor.GREEN + "Funds have been taken out of your account.");
                p.closeInventory();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.adventurer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.explorer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.hero false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.titan false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.legend true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.ultimate true");

                e.setCancelled(true);

                return;

            } else if (slot == 6){

                if(Main.getEconomy().getBalance(p) < 30000000) {
                    p.sendMessage(ChatColor.RED + "You don't have enough money for this rank!");
                    p.closeInventory();
                    return;
                }

                if(!p.hasPermission("cc.rank.legend")) {
                    p.sendMessage(ChatColor.RED + "You may not purchase this rank");
                    p.closeInventory();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.GRAY + "Congratulations, " + ChatColor.AQUA + p.getName() + ChatColor.GRAY + " on obtaining "
                        + ChatColor.AQUA + "Legend Rank" +
                        ChatColor.GRAY + "!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " group set legend");
                Main.getInstance().getEconomy().withdrawPlayer(p, 30000000);
                p.sendMessage(ChatColor.GREEN + "Funds have been taken out of your account.");
                p.closeInventory();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.adventurer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.explorer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.hero false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.titan false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.legend false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.ultimate true");

                e.setCancelled(true);

                return;

            } else if (slot == 8){

                if(Main.getEconomy().getBalance(p) < 100000000) {
                    p.sendMessage(ChatColor.RED + "You don't have enough money for this rank!");
                    p.closeInventory();
                    return;
                }

                if(!p.hasPermission("cc.rank.ultimate")) {
                    p.sendMessage(ChatColor.RED + "You may not purchase this rank");
                    p.closeInventory();
                    return;
                }

                Bukkit.broadcastMessage(ChatColor.GRAY + "Congratulations, " + ChatColor.AQUA + p.getName() + ChatColor.GRAY + " on obtaining "
                        + ChatColor.AQUA + "Ultimate Rank" +
                        ChatColor.GRAY + "!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " group set ultimate");
                Main.getInstance().getEconomy().withdrawPlayer(p, 100000000);
                p.sendMessage(ChatColor.GREEN + "Funds have been taken out of your account.");
                p.closeInventory();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.adventurer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.explorer false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.hero false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.titan false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.legend false");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set cc.rank.ultimate false");

                e.setCancelled(true);

                return;
            }
        } else {
            return;
        }
    }
}