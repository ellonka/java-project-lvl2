package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    public void testDifferBetweenTwoSimpleJsonWithStylish() throws IOException {
        String pathToFile1 = "./src/test/resources/file1.json";
        String pathToFile2 = "./src/test/resources/file2.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile1, pathToFile2));
    }

    @Test
    public void testDifferBetweenTwoSimpleYamlWithStylish() throws IOException {
        String pathToFile1 = "./src/test/resources/file1.yml";
        String pathToFile2 = "./src/test/resources/file2.yml";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile1, pathToFile2));
    }

    @Test
    public void testDifferBetweenTwoJsonWithNestedStructWithStylish() throws IOException {
        String pathToFile3 = "./src/test/resources/file3.json";
        String pathToFile4 = "./src/test/resources/file4.json";

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4));
    }

    @Test
    public void testDifferBetweenTwoYamlWithNestedStructWithStylish() throws IOException {
        String pathToFile3 = "./src/test/resources/file3.yml";
        String pathToFile4 = "./src/test/resources/file4.yml";

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4));
    }

    @Test
    public void testDifferBetweenTwoJsonWithNestedStructWithPlain() throws IOException {
        String pathToFile3 = "./src/test/resources/file3.json";
        String pathToFile4 = "./src/test/resources/file4.json";

        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "plain"));
    }

    @Test
    public void testDifferBetweenTwoYamlWithNestedStructWithPlain() throws IOException {
        String pathToFile3 = "./src/test/resources/file3.yml";
        String pathToFile4 = "./src/test/resources/file4.yml";

        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "plain"));
    }

    @Test
    public void testDifferBetweenTwoFilesWithJson() throws IOException {
        String pathToFile3 = "./src/test/resources/file1.json";
        String pathToFile4 = "./src/test/resources/file2.json";

        String expected = "{\n"
                + "  \"follow\" : {\n"
                + "    \" - \" : false,\n"
                + "    \" + \" : null\n"
                + "  },\n"
                + "  \"host\" : {\n"
                + "    \" - \" : \"hexlet.io\",\n"
                + "    \" + \" : \"hexlet.io\"\n"
                + "  },\n"
                + "  \"proxy\" : {\n"
                + "    \" - \" : \"123.234.53.22\",\n"
                + "    \" + \" : null\n"
                + "  },\n"
                + "  \"timeout\" : {\n"
                + "    \" - \" : 50,\n"
                + "    \" + \" : 20\n"
                + "  },\n"
                + "  \"verbose\" : {\n"
                + "    \" - \" : null,\n"
                + "    \" + \" : true\n"
                + "  }\n"
                + "}";
        assertEquals(expected, Differ.generate(pathToFile3, pathToFile4, "json"));
    }
}
