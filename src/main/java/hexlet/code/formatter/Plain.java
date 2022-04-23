package hexlet.code.formatter;

import java.util.Collection;
import java.util.Map;

public final class Plain implements Format {
    private StringBuilder result;

    public Plain() {
        result = new StringBuilder();
    }

    @Override
    public void collect(String modification, String key, Object value1, Object value2) {
        switch (modification) {
            case "ADDED" -> result.append("Property " + editValue(key) + " was added with value: "
                    + editValue(value2) + "\n");
            case "DELETED" -> result.append("Property " + editValue(key) + " was removed\n");
            case "UPDATED" -> result.append("Property " + editValue(key) + " was updated. From "
                    + editValue(value1) + " to " + editValue(value2) + "\n");
            default -> result.append("");
        }
    }

    @Override
    public String print() {
        String output = result.toString();
        return output.substring(0, output.length() - 1);
    }

    private String editValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Collection || value instanceof Map<?, ?>) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "\'" + value + "\'";
        }
        return value.toString();
    }
}
