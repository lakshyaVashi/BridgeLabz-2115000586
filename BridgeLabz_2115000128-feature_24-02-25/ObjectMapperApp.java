import java.lang.reflect.*;
import java.util.*;

class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Field '" + fieldName + "' not found in " + clazz.getSimpleName());
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Failed to create object: " + e.getMessage(), e);
        }
    }
}

class User {
    private String username;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ObjectMapperApp {
    public static void main(String[] args) {
        Map<String, Object> userProperties = new HashMap<>();
        userProperties.put("username", "Alice");
        userProperties.put("age", 28);

        User user = CustomObjectMapper.toObject(User.class, userProperties);
        System.out.println("Mapped User: " + user);
    }
}