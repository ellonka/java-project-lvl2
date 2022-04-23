package hexlet.code.format;

public class Format {
    private static Formatter formatter;

    public static void chooseFormat(String format) {
        formatter = switch (format) {
            case "stylish" -> new Stylish();
            default -> throw new IllegalArgumentException("This format for print differ isn't supported");
        };
    }
    public static void collect(String modification, String key, Object value) {
        formatter.collect(modification, key, value);
    }
    public static String print() {
        return formatter.print();
    }
}
