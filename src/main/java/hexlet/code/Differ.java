package hexlet.code;

import hexlet.code.format.Format;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> exchanger = new TreeMap<>();
        Map<String, Object> mapFromFile1 = Parser.parse(filePath1);
        Map<String, Object> mapFromFile2 = Parser.parse(filePath2);
        exchanger.putAll(mapFromFile2);
        exchanger.putAll(mapFromFile1);

        Format.chooseFormat(format);
        for (String key: exchanger.keySet()) {
            if (!mapFromFile1.containsKey(key)) {
                Format.collect("ADDED", key, mapFromFile2.get(key));
            } else if (!mapFromFile2.containsKey(key)) {
                Format.collect("DELETED", key, mapFromFile1.get(key));
            } else if (Objects.equals(mapFromFile2.get(key), mapFromFile1.get(key))) {
                Format.collect("UNCHANGED", key, mapFromFile1.get(key));
            } else {
                Format.collect("DELETED", key, mapFromFile1.get(key));
                Format.collect("ADDED", key, mapFromFile2.get(key));
            }
        }

        return Format.print();
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
}
