package hexlet.code.formatter;

public class Formatter {
    private static Format format;

    public static void chooseFormat(String formatForOut) {
        Formatter.format = switch (formatForOut) {
            case "stylish" -> new StylishFormat();
            case "plain" -> new PlainFormat();
            case "json" -> new JsonFormat();
            default -> throw new IllegalArgumentException(formatForOut + "format for print differ isn't supported");
        };
    }
    public static void collectData(String modification, String key, Object value1, Object value2) {
        format.collectData(modification, key, value1, value2);
    }
    public static String prepareToPrint() {
        return format.prepareToPrint();
    }
}
