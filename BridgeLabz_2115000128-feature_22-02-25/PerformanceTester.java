import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTester {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}

public class PerformanceTesterTest {
    private PerformanceTester performanceTester;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        performanceTester = new PerformanceTester();
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() throws InterruptedException {
        assertEquals("Completed", performanceTester.longRunningTask());
    }
}
