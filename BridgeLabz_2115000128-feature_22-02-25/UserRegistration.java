import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class UserRegistration {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}

public class UserRegistrationTest {
    private UserRegistration userRegistration;

    @BeforeEach
    public void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("john_doe", "john@example.com", "Password1"));
    }

    @Test
    public void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john@example.com", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john@example.com", "Password1"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "johnexample.com", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john@.com", "Password1"));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john@example.com", "pass"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john@example.com", null));
    }
}