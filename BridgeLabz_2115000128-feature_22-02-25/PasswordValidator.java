import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,}$");

    public boolean isValid(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }
}

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        assertTrue(passwordValidator.isValid("Password1"));
        assertTrue(passwordValidator.isValid("StrongPass123"));
    }

    @Test
    public void testInvalidPasswordTooShort() {
        assertFalse(passwordValidator.isValid("Pass1"));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        assertFalse(passwordValidator.isValid("password1"));
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        assertFalse(passwordValidator.isValid("Password"));
    }

    @Test
    public void testInvalidPasswordNull() {
        assertFalse(passwordValidator.isValid(null));
    }
}