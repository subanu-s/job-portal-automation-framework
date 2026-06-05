package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadConfig() {
        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(
                    "src/test/resources/config/config.properties"
            );

            properties.load(file);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadConfig();
        }

        return properties.getProperty(key);
    }
}