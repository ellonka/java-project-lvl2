package hexlet.code.formatter;

public interface Format {
    void collectData(String modification, String key, Object value1, Object value2);
    String prepareToPrint();
}
