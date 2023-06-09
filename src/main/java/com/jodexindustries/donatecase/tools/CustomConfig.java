package com.jodexindustries.donatecase.tools;

import com.jodexindustries.donatecase.dc.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class CustomConfig {
    private static File filec;
    private static File filek;
    private static File filecon;
    private static File fileanim;
    private static FileConfiguration Cases;
    private static FileConfiguration Keys;
    public static YamlConfiguration Config;
    public static YamlConfiguration Animations;

    public CustomConfig() {
        filecon = new File(Bukkit.getServer().getPluginManager().getPlugin("DonateCase").getDataFolder(), "Config.yml");
        Config = YamlConfiguration.loadConfiguration(filecon);
    }

    public static void setup() {
        fileanim = new File(Bukkit.getServer().getPluginManager().getPlugin("DonateCase").getDataFolder(), "Animations.yml");
        Animations = YamlConfiguration.loadConfiguration(fileanim);
        filec = new File(Bukkit.getServer().getPluginManager().getPlugin("DonateCase").getDataFolder(), "Cases.yml");
        Cases = YamlConfiguration.loadConfiguration(filec);
        filek = new File(Bukkit.getServer().getPluginManager().getPlugin("DonateCase").getDataFolder(), "Keys.yml");
        Keys = YamlConfiguration.loadConfiguration(filek);
        filecon = new File(Bukkit.getServer().getPluginManager().getPlugin("DonateCase").getDataFolder(), "Config.yml");
        Config = YamlConfiguration.loadConfiguration(filecon);
    }

    public static void saveCases() {
        try {
            Cases.save(filec);
            Cases = YamlConfiguration.loadConfiguration(filec);
        } catch (IOException var1) {
            Main.instance.getLogger().log(Level.WARNING, "Couldn't save Cases.yml");
        }

    }

    public static void saveConfig() {
        try {
            Config.save(filecon);
        } catch (IOException var1) {
            Main.instance.getLogger().log(Level.WARNING, "Couldn't save Config.yml");
        }

    }

    public static void saveKeys() {
        try {
            Keys.save(filek);
            Keys = YamlConfiguration.loadConfiguration(filek);
        } catch (IOException var1) {
            Main.instance.getLogger().log(Level.WARNING, "Couldn't save Keys.yml");
        }

    }

    public static void saveAnimations() {
        try {
            Animations.save(fileanim);
        } catch (IOException var1) {
            Main.instance.getLogger().log(Level.WARNING, "Couldn't save Animations.yml");
        }
    }

    public static FileConfiguration getCases() {
        return Cases;
    }

    public static FileConfiguration getKeys() {
        return Keys;
    }

    public static FileConfiguration getConfig() {
        return Config;
    }

    public static FileConfiguration getAnimations() {
        return Animations;
    }
}
