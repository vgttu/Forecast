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

        String name = "test.txt";
        String text = "Test writing";

        try {
            fh.write(new ArrayList<>(Arrays.asList(text)), name);

            List<String> lines = fh.read(name);

            assertEquals(text, lines.get(0));

            fh.delete(name);
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testReadAndWriteWithMock() {
        FileHandler fh = FileHandler.mock();

        try {
            List<String> linesWrite = new ArrayList<>();

            linesWrite.add("Tallinn,EE");
            linesWrite.add("London,GB");

            assertTrue(fh.write(linesWrite, "input.txt"));

            List<String> linesRead = fh.read("input.txt");

            assertEquals(linesWrite.get(0), linesRead.get(0));
            assertEquals(linesWrite.get(1), linesRead.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}