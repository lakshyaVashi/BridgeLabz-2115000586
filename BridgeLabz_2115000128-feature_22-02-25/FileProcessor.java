import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

public class FileProcessorTest {
    private FileProcessor fileProcessor;
    private final String filename = "testfile.txt";
    private final String content = "Sample file content.";

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    @Test
    public void testWriteToFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        assertTrue(new File(filename).exists());
    }

    @Test
    public void testReadFromFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        assertEquals(content, fileProcessor.readFromFile(filename));
    }

    @Test
    public void testReadFromNonExistentFile() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}
