import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

public class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected());
    }

    @Test
    public void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected());
    }
}