import com.weather.FileHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void testReadAndWrite() {
        FileHandler fh = new FileHandler();

        try {
            String name = "test.txt";

            fh.write(new ArrayList<>(Arrays.asList("Test writing")), name);

            List<String> lines = fh.read(name);

            assertEquals("Test writing", lines.get(0));

            fh.delete(name);
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testReadAndWriteWithMock() {
        FileHandler fh = new FileHandler();

        FileHandler.mock();

        try {
            List<String> lines = fh.read("input.txt");

            assertEquals("Tallinn,EE", lines.get(0));
            assertEquals("London,GB", lines.get(1));
            assertTrue(fh.write(lines, "input.txt"));
            assertTrue(fh.delete("input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}