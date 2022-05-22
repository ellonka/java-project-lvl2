package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testDifferBetweenTwoJsonWithStylish() throws IOException {
        String pathToFile3 = buildPathToFileByItsName("file3.json");
        String pathToFile4 = buildPathToFileByItsName("file4.json");
        String expected = extractDataFromFile(buildPathToFileByItsName("expectedResultStylish.txt"));
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "stylish"));
    }

    @Test
    public void testDifferBetweenTwoYamlWithStylish() throws IOException {
        String pathToFile3 = buildPathToFileByItsName("file3.yml");
        String pathToFile4 = buildPathToFileByItsName("file4.yml");
        String expected = extractDataFromFile(buildPathToFileByItsName("expectedResultStylish.txt"));
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "stylish"));
    }

    @Test
    public void testDifferBetweenTwoJsonWithPlain() throws IOException {
        String pathToFile3 = buildPathToFileByItsName("file3.json");
        String pathToFile4 = buildPathToFileByItsName("file4.json");
        String expected = extractDataFromFile(buildPathToFileByItsName("expectedResultPlain.txt"));
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "plain"));
    }

    @Test
    public void testDifferBetweenTwoYamlWithPlain() throws IOException {
        String pathToFile3 = buildPathToFileByItsName("file3.yml");
        String pathToFile4 = buildPathToFileByItsName("file4.yml");
        String expected = extractDataFromFile(buildPathToFileByItsName("expectedResultPlain.txt"));
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "plain"));
    }

    @Test
    public void testDifferBetweenTwoFilesWithJson() throws IOException {
        String pathToFile3 = buildPathToFileByItsName("file1.json");
        String pathToFile4 = buildPathToFileByItsName("file2.json");
        String expected = extractDataFromFile(buildPathToFileByItsName("expectedResultJson.txt"));
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "json"));
    }

    private String extractDataFromFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath).toAbsolutePath());
    }

    private String buildPathToFileByItsName(String fileName) {
        return "./src/test/resources/" + fileName;
    }
}
