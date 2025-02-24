import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest {
    private NumberUtils numberUtils;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        numberUtils = new NumberUtils();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    public void testIsEven(int number) {
        if (number % 2 == 0) {
            assertTrue(numberUtils.isEven(number));
        } else {
            assertFalse(numberUtils.isEven(number));
        }
    }
}