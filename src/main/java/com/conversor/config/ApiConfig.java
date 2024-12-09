package com.conversor.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiConfig {
    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    public static String getApiKey() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_FILE));
            return properties.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la clave de API: " + e.getMessage());
        }
    }
}
