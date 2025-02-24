import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_role")
    private String role;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, String role, String email) {
        this.username = username;
        this.role = role;
        this.email = email;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Map<String, String> jsonElements = new HashMap<>();
            Class<?> objClass = obj.getClass();

            for (Field field : objClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonElements.put(annotation.name(), field.get(obj).toString());
                }
            }

            StringBuilder jsonBuilder = new StringBuilder("{");
            jsonElements.forEach((key, value) ->
                    jsonBuilder.append("\"" + key + "\": \"" + value + "\", "));

            if (!jsonElements.isEmpty()) {
                jsonBuilder.setLength(jsonBuilder.length() - 2); 
            }
            jsonBuilder.append("}");

            return jsonBuilder.toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error during JSON serialization", e);
        }
    }
}

public class JsonSerializationApp {
    public static void main(String[] args) {
        User user = new User("Alice", "ADMIN", "alice@example.com");
        String jsonString = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON: " + jsonString);
    }
}
