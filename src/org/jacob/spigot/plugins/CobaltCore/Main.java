package org.jacob.spigot.plugins.CobaltCore;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jacob.spigot.plugins.CobaltCore.events.*;
import org.jacob.spigot.plugins.CobaltCore.modules.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main extends JavaPlugin {

    public static Economy econ = null;

    List<String> AnnounceStrings = getConfig().getStringList("announcements");
    String[] aStrings = {"&7We have a website! Check it out at &3https://cobaltcraft.com",
            "&7Feel free to donate to our Store! &3https://cobaltcraftmc.buycraft.net",
            "&7Check out our Discord! You can join it at &3https://discord.gg/8NTkYEZ"};

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private File playerDataFile;
    private FileConfiguration playerData;

    @Override
    public void onEnable() {

        instance = this;

        createPlayerData();

        getConfig().options().copyDefaults(true);
        getConfig().addDefault("announcements", Arrays.asList(aStrings));
        saveConfig();

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new RankJoinListener(), this);
        pm.registerEvents(new StaffChatListener(), this);
        pm.registerEvents(new PlayerDataJoinListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new SignColorListener(), this);
        pm.registerEvents(new PlayerBlackListJoinListener(), this);
        pm.registerEvents(new InventoryDataListener(), this);
        pm.registerEvents(new RankGUICommand(), this);
        pm.registerEvents(new SpawnerShopGUI(), this);

        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("cobaltcore").setExecutor(new ReloadCommand());
        getCommand("announce").setExecutor(new AnnounceCommand());
        getCommand("sc").setExecutor(new StaffChatCommand());
        getCommand("forceannounce").setExecutor(new ForceAnnouncementCommand());
        getCommand("blacklist").setExecutor(new BlackListCommand());
        getCommand("launch").setExecutor(new LaunchCommand());
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("ranks").setExecutor(new RankGUICommand());
        getCommand("spawnershop").setExecutor(new SpawnerShopGUI());
        getCommand("nether").setExecutor(new WorldCommand());
        getCommand("world").setExecutor(new WorldCommand());

        autoAnnouncer();

        if(!setEconomy()){
            Bukkit.shutdown();
        }
    }

    private void createPlayerData() {
        playerDataFile = new File(getDataFolder(), "data.yml");
        if (!playerDataFile.exists()) {
            playerDataFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }

        playerData = new YamlConfiguration();
        try {
            playerData.load(playerDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public FileConfiguration getPlayerData() {
        return this.playerData;
    }

    public void savePlayerData() {
        try {
            playerData.save(playerDataFile);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void autoAnnouncer() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {

            Random rando = new Random();
            String randomString = AnnounceStrings.get(rando.nextInt(AnnounceStrings.size()));
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', randomString));
        }, 0, 4000);

    }

    private boolean setEconomy() {
        RegisteredServiceProvider<Economy> economyProviter = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economyProviter != null) {
            econ = economyProviter.getProvider();

        }

        return (econ != null);
    }

    public static Economy getEconomy() {
        return econ;
    }
}
