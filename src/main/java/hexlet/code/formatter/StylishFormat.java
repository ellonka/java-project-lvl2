package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public final class StylishFormat implements Format {
    @Override
    public String prepareToPrint(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> map: diff) {
            switch ((String) map.get("status")) {
                case "ADDED" -> result.append("  + " + map.get("key") + ": " + map.get("value2") + "\n");
                case "DELETED" -> result.append("  - " + map.get("key") + ": " + map.get("value1") + "\n");
                case "UNCHANGED" -> result.append("    " + map.get("key") + ": " + map.get("value1") + "\n");
                case "UPDATED" -> result.append("  - " + map.get("key") + ": " + map.get("value1") + "\n"
                        + "  + " + map.get("key") + ": " + map.get("value2") + "\n");
                default -> result.append("");
            }
        }
        result.append("}");
        return result.toString();
    }
}
