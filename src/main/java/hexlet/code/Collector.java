package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;

public class Collector {
    private static final String KEY = "key";
    private static final String STATUS = "status";
    private static final String VALUE1 = "value1";
    private static final String VALUE2 = "value2";

    public static Map<String, Object> createDiff(String key, String status, Object value1, Object value2) {
        Map<String, Object> collector = new LinkedHashMap<>();
        collector.put(KEY, key);
        collector.put(STATUS, status);
        collector.put(VALUE1, value1);
        collector.put(VALUE2, value2);
        return collector;
    }

}
