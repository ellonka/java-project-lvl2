package hexlet.code.formatter;

public class Formatter {
    private static Format format;

    public static void chooseFormat(String formatForOut) {
        Formatter.format = switch (formatForOut) {
            case "stylish" -> new Stylish();
            case "plain" -> new Plain();
            default -> throw new IllegalArgumentException("This format for print differ isn't supported");
        };
    }
    public static void collect(String modification, String key, Object value1, Object value2) {
        format.collect(modification, key, value1, value2);
    }
    public static String print() {
        return format.print();
    }
}
