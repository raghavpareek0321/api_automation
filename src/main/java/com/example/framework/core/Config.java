package com.example.framework.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();
    private static final String DEFAULT_ENV = "dev";
    private static final String CONFIG_PATH_TEMPLATE = "/config/%s.properties";

    static {
        String env = System.getProperty("env");
        if (env == null || env.trim().isEmpty()) {
            env = DEFAULT_ENV;
        }
        String configPath = String.format(CONFIG_PATH_TEMPLATE, env);

        try (InputStream input = Config.class.getResourceAsStream(configPath)) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + configPath +
                        ". Make sure the file exists in src/test/resources/config/");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + configPath, e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing configuration key: " + key);
        }
        return value;
    }
}
