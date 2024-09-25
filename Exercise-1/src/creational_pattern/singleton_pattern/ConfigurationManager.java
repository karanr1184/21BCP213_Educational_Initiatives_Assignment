package creational_pattern.singleton_pattern;

import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties configProperties;

    private ConfigurationManager() {
        // Private constructor to prevent instantiation
        configProperties = new Properties();
        // Load config from a file or database
        configProperties.setProperty("appName", "MyApp");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfigValue(String key) {
        return configProperties.getProperty(key);
    }
}
