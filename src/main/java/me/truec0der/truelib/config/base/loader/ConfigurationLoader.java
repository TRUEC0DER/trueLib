package me.truec0der.truelib.config.base.loader;

import java.io.File;

public interface ConfigurationLoader<T> {
    T load(File directory, String fileName);

    T load(File directory, String fileName, String defaultFileName);

    void save(T config, File file);

    T createNewConfig();
}
