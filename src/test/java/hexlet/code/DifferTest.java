package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    public void testDifferBetweenTwoSimpleJson() {
        String pathToFile1 = "./src/test/resources/file1.json";
        String pathToFile2 = "./src/test/resources/file2.json";

        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile1, pathToFile2));
    }
}
