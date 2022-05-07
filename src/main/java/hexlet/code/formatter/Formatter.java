package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    private static Format format;

    public static String formatData(String formatForOut, List<Map<String, Object>> diff) {
        Formatter.format = switch (formatForOut) {
            case "stylish" -> new StylishFormat();
            case "plain" -> new PlainFormat();
            case "json" -> new JsonFormat();
            default -> throw new IllegalArgumentException(formatForOut + "format for print differ isn't supported");
        };
        return format.prepareToPrint(diff);
    }
}
