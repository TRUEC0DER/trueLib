package me.truec0der.truelib.config.base.loader;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class YamlConfigurationLoader implements ConfigurationLoader<YamlConfiguration> {
    private final Plugin plugin;

    public YamlConfigurationLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public YamlConfiguration load(File directory, String fileName) {
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public YamlConfiguration load(File directory, String fileName, String defaultFileName) {
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        InputStream defaultStream = plugin.getResource(defaultFileName);

        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            config.setDefaults(defaultConfig);
            config.options().copyDefaults(true);
        }

        return config;
    }

    @Override
    public void save(YamlConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public YamlConfiguration createNewConfig() {
        return new YamlConfiguration();
    }
}
