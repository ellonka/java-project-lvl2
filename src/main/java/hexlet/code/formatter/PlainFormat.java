package hexlet.code.formatter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class PlainFormat implements Format {
    @Override
    public String prepareToPrint(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> map: diff) {
            switch ((String) map.get("status")) {
                case "ADDED" -> result.append("Property " + stringify(map.get("key")) + " was added with value: "
                        + stringify(map.get("value2")) + "\n");
                case "DELETED" -> result.append("Property " + stringify(map.get("key")) + " was removed\n");
                case "UPDATED" -> result.append("Property " + stringify(map.get("key")) + " was updated. From "
                        + stringify(map.get("value1")) + " to " + stringify(map.get("value2")) + "\n");
                default -> result.append("");
            }
        }
        String output = result.toString();
        return output.substring(0, output.length() - 1);
    }

    private String stringify(Object value) {
        if (value instanceof Collection || value instanceof Map<?, ?>) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "\'" + value + "\'";
        }
        return Objects.toString(value);
    }
}
