package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2) {
        Map<String, String> exchanger = new TreeMap<>();
        Map<String, Object> mapFromFile1 = Parser.parser(filePath1);
        Map<String, Object> mapFromFile2 = Parser.parser(filePath2);

        for (String key: mapFromFile1.keySet()) {
            if (mapFromFile1.get(key).equals(mapFromFile2.get(key))) {
                exchanger.put(key, "   " + key + ": " + mapFromFile1.get(key) + "\n");
            } else {
                exchanger.put(key, " - " + key + ": " + mapFromFile1.get(key) + "\n"
                        + " + " + key + ": " + mapFromFile2.get(key) + "\n");
            }
            if (mapFromFile2.remove(key) == null) {
                exchanger.put(key, " - " + key + ": " + mapFromFile1.get(key) + "\n");
            }
        }
        for (String key: mapFromFile2.keySet()) {
            exchanger.put(key, " + " + key + ": " + mapFromFile2.get(key) + "\n");
        }

        StringBuilder result = new StringBuilder("{\n");
        for (String key: exchanger.keySet()) {
            result.append(exchanger.get(key));
        }
        result.append("}");
        return result.toString();
    }
}
