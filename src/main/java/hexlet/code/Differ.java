package hexlet.code;

import hexlet.code.formatter.Formatter;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> mapFromFile1 = FileProcessing.extractMapFromFile(filePath1);
        Map<String, Object> mapFromFile2 = FileProcessing.extractMapFromFile(filePath2);

        List<Map<String, Object>> diff = buildDiff(mapFromFile1, mapFromFile2);

        return Formatter.formatData(format, diff);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    private static List<Map<String, Object>> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> exchanger = new TreeMap<>();
        exchanger.putAll(map1);
        exchanger.putAll(map2);

        List<Map<String, Object>> diff = new ArrayList<>();

        for (String key: exchanger.keySet()) {
            if (!map1.containsKey(key)) {
                diff.add(createNode(key, "ADDED", map1.get(key), map2.get(key)));
            } else if (!map2.containsKey(key)) {
                diff.add(createNode(key, "DELETED", map1.get(key), map2.get(key)));
            } else if (Objects.equals(map2.get(key), map1.get(key))) {
                diff.add(createNode(key, "UNCHANGED", map1.get(key), map2.get(key)));
            } else {
                diff.add(createNode(key, "UPDATED", map1.get(key), map2.get(key)));
            }
        }
        return diff;
    }

    private static Map<String, Object> createNode(String key, String status, Object value1, Object value2) {
        Map<String, Object> collector = new LinkedHashMap<>();
        collector.put("key", key);
        collector.put("status", status);
        collector.put("value1", value1);
        collector.put("value2", value2);
        return collector;
    }
}
