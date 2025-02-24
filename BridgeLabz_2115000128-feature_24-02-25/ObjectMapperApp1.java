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

    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            List<String> fieldPairs = new ArrayList<>();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                String formattedValue = value instanceof String ? "\"" + value + "\"" : String.valueOf(value);
                fieldPairs.add("\"" + field.getName() + "\": " + formattedValue);
            }
            jsonBuilder.append(String.join(", ", fieldPairs));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to generate JSON: " + e.getMessage(), e);
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
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

public class ObjectMapperApp1 {
    public static void main(String[] args) {
        Map<String, Object> userProperties = new HashMap<>();
        userProperties.put("username", "Alice");
        userProperties.put("age", 28);

        User user = CustomObjectMapper.toObject(User.class, userProperties);
        System.out.println("Mapped User: " + user);
        System.out.println("JSON Representation: " + CustomObjectMapper.toJson(user));
    }
}
