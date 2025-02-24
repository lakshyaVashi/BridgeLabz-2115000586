import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    public String formatDate(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return outputFormatter.format(date);
    }
}

public class DateFormatterTest {
    private DateFormatter dateFormatter;

    @BeforeEach
    public void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    public void testValidDate() {
        assertEquals("15-02-2024", dateFormatter.formatDate("2024-02-15"));
        assertEquals("01-01-2023", dateFormatter.formatDate("2023-01-01"));
        assertEquals("31-12-2025", dateFormatter.formatDate("2025-12-31"));
    }

    @Test
    public void testInvalidDate() {
        assertThrows(DateTimeParseException.class, () -> dateFormatter.formatDate("15/02/2024"));
        assertThrows(DateTimeParseException.class, () -> dateFormatter.formatDate("2024-15-02"));
        assertThrows(DateTimeParseException.class, () -> dateFormatter.formatDate("invalid-date"));
    }
}