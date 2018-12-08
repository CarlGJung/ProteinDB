package com.config;

import com.googlecode.protobuf.format.JsonFormat;
import com.proto.ConfigStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zhanghaijun
 */
public class Configuration {

    private final static Configuration instance = new Configuration();
    private ConfigStore.Config config;

    private Configuration() {

    }

    public static Configuration getInstance() {
        return instance;
    }

    public ConfigStore.Config getConfig() throws IOException {
        if (config == null) {
            return config;
        } else {
            return readConfig().build();
        }
    }

    public void loadConfig() throws IOException {
        config = readConfig().build();
    }

    public ConfigStore.Config.Builder readConfig() throws FileNotFoundException, IOException {
        File configFile = new File("config/config.json");
        JsonFormat jsonFormat = new JsonFormat();
        ConfigStore.Config.Builder configBuilder = ConfigStore.Config.newBuilder();
        jsonFormat.merge(new FileInputStream(configFile), configBuilder);
        return configBuilder;
    }
}
