package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatData(String formatForOut, List<Map<String, Object>> diff)
            throws JsonProcessingException {
        Format format = switch (formatForOut) {
            case "stylish" -> new StylishFormat();
            case "plain" -> new PlainFormat();
            case "json" -> new JsonFormat();
            default -> throw new IllegalArgumentException(formatForOut + "format for print differ isn't supported");
        };
        return format.prepareToPrint(diff);
    }
}
