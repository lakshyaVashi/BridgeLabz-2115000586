import static org.junit.jupiter.api.Assertions.*;
import org.junit.japi.BeforeEach;
import org.junit.api.Test;

public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    public void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("", stringUtils.reverse(""));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("WORLD", stringUtils.toUpperCase("World"));
    }
}
