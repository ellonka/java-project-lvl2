package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> mapFromFile1 = extractMapFromJson(filePath1);
        Map<String, Object> mapFromFile2 = extractMapFromJson(filePath2);

        Map<String, String> exchanger = new TreeMap<>();

        for (String key: mapFromFile1.keySet()) {
            if (mapFromFile1.get(key).equals(mapFromFile2.get(key))) {
                exchanger.put(key, "   " + key + ": " + mapFromFile1.get(key) + "\n");
            } else {
                exchanger.put(key, " - " + key + ": " + mapFromFile1.get(key) + "\n" +
                        " + " + key + ": " + mapFromFile2.get(key) + "\n");
            }
            if (mapFromFile2.remove(key) == null) {
                exchanger.put(key, " - " + key + ": " + mapFromFile1.get(key) + "\n");
            }
        }
        for (String key: mapFromFile2.keySet()) {
            exchanger.put(key, " + " + key + ": " + mapFromFile2.get(key) + "\n");
        }
        String result = "{\n";
        for (String key: exchanger.keySet()) {
            result += exchanger.get(key);
        }
        return result + "}";
    }

    private static Map<String, Object> extractMapFromJson(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        String jsonString = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, Map.class);
    }

}
