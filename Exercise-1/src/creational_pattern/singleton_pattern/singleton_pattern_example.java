package creational_pattern.singleton_pattern;

public class singleton_pattern_example {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        String appName = configManager.getConfigValue("appName");
        System.out.println("App Name: " + appName);
    }
}
