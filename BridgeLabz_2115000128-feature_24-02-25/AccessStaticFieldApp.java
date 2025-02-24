import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class AccessStaticFieldApp {
    public static void main(String[] args) {
        try {
            Class<Configuration> clazz = Configuration.class;
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            System.out.println("Original API_KEY: " + apiKeyField.get(null));
            apiKeyField.set(null, "UPDATED_KEY_123");
            System.out.println("Modified API_KEY: " + apiKeyField.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}