import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisionHandler {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class DivisionHandlerTest {
    private DivisionHandler divisionHandler;

    @BeforeEach
    public void setUp() {
        divisionHandler = new DivisionHandler();
    }

    @Test
    public void testDivide() {
        assertEquals(5, divisionHandler.divide(10, 2));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            divisionHandler.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}