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

public class SpawnerShopGUI implements Listener, CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("spawnershop")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only players can execute this command");
                return true;
            }
            Player p = (Player) commandSender;

            if(!p.hasPermission("cc.spawner.shop")) {
                p.sendMessage(ChatColor.RED + "No permissions");
                return true;
            }

            Inventory spawnerinv = Bukkit.createInventory(null, 27, "Spawners");

            spawnerinv.setItem(0, new ItemStackBuilder(Material.CREEPER_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Creeper Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$5,000,000"
                    )).build());
            spawnerinv.setItem(1, new ItemStackBuilder(Material.SKELETON_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Skeleton Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$500,000"
                    )).build());
            spawnerinv.setItem(2, new ItemStackBuilder(Material.SPIDER_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Spider Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$750,000"
                    )).build());
            spawnerinv.setItem(3, new ItemStackBuilder(Material.ZOMBIE_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Zombie Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$500,000"
                    )).build());
            spawnerinv.setItem(4, new ItemStackBuilder(Material.SLIME_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Slime Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$10,000,000"
                    )).build());
            spawnerinv.setItem(5, new ItemStackBuilder(Material.ZOMBIE_PIGMAN_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Zombie Pigman Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$3,000,000"
                    )).build());
            spawnerinv.setItem(6, new ItemStackBuilder(Material.ENDERMAN_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Enderman Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$10,000,000"
                    )).build());
            spawnerinv.setItem(7, new ItemStackBuilder(Material.CAVE_SPIDER_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Cave Spider Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$750,000"
                    )).build());
            spawnerinv.setItem(8, new ItemStackBuilder(Material.SILVERFISH_SPAWN_EGG)
                    .name(ChatColor.GREEN + "SilverFish Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$1,000,000"
                    )).build());

            spawnerinv.setItem(9, new ItemStackBuilder(Material.BLAZE_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Blaze Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$1,000,000"
                    )).build());

            spawnerinv.setItem(10, new ItemStackBuilder(Material.BAT_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Bat Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$1,000,000"
                    )).build());

            spawnerinv.setItem(11, new ItemStackBuilder(Material.WITCH_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Witch Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$5,000,000"
                    )).build());

            spawnerinv.setItem(12, new ItemStackBuilder(Material.PIG_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Pig Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$2,000,000"
                    )).build());

            spawnerinv.setItem(13, new ItemStackBuilder(Material.SHEEP_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Sheep Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$2,000,000"
                    )).build());

            spawnerinv.setItem(14, new ItemStackBuilder(Material.COW_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Cow Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$2,000,000"
                    )).build());

            spawnerinv.setItem(15, new ItemStackBuilder(Material.CHICKEN_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Chicken Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$2,000,000"
                    )).build());

            spawnerinv.setItem(16, new ItemStackBuilder(Material.SQUID_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Squid Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$5,000,000"
                    )).build());

            spawnerinv.setItem(17, new ItemStackBuilder(Material.WOLF_SPAWN_EGG)
                    .name(ChatColor.GREEN + "Wolf Spawner")
                    .lore(Arrays.asList(
                            ChatColor.GRAY + "Price: " +
                                    ChatColor.AQUA + "$5,000,000"
                    )).build());

            p.openInventory(spawnerinv);
            return true;
        }

        return true;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("Spawners")) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();

            int slot = e.getSlot();

            if(slot == 0) {

                if(Main.getEconomy().getBalance(p) < 5000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " creeper_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 5000000);
            }
            if(slot == 1) {

                if(Main.getEconomy().getBalance(p) < 500000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " skeleton_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 500000);
            }
            if(slot == 2) {

                if(Main.getEconomy().getBalance(p) < 750000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " spider_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 750000);
            }
            if(slot == 3) {

                if(Main.getEconomy().getBalance(p) < 500000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " zombie_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 500000);
            }
            if(slot == 4) {

                if(Main.getEconomy().getBalance(p) < 10000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " slime_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 10000000);
            }
            if(slot == 5) {

                if(Main.getEconomy().getBalance(p) < 3000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " zombie_pigman_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 3000000);
            }
            if(slot == 6) {

                if(Main.getEconomy().getBalance(p) < 10000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " enderman_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 10000000);
            }
            if(slot == 7) {

                if(Main.getEconomy().getBalance(p) < 750000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " cave_spider_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 750000);
            }
            if(slot == 8) {

                if(Main.getEconomy().getBalance(p) < 1000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " silverfish_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 1000000);
            }
            if(slot == 9) {

                if(Main.getEconomy().getBalance(p) < 1000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " blaze_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 1000000);
            }
            if(slot == 10) {

                if(Main.getEconomy().getBalance(p) < 1000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " bat_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 1000000);
            }
            if(slot == 11) {

                if(Main.getEconomy().getBalance(p) < 5000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " witch_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 5000000);
            }
            if(slot == 12) {

                if(Main.getEconomy().getBalance(p) < 2000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " pig_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 2000000);
            }
            if(slot == 13) {

                if(Main.getEconomy().getBalance(p) < 2000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " sheep_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 2000000);
            }
            if(slot == 14) {

                if(Main.getEconomy().getBalance(p) < 2000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " cow_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 2000000);
            }
            if(slot == 15) {

                if(Main.getEconomy().getBalance(p) < 2000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " chicken_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 2000000);
            }
            if(slot == 16) {

                if(Main.getEconomy().getBalance(p) < 5000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " squid_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 5000000);
            }
            if(slot == 17) {

                if(Main.getEconomy().getBalance(p) < 5000000) {
                    p.sendMessage(ChatColor.RED + "You do not have enough money!");
                    return;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " wolf_spawner 1");
                p.sendMessage(ChatColor.GREEN + "Funds have been taken from your account");
                Main.getEconomy().withdrawPlayer(p, 5000000);
            }

            return;
        }
    }
}
