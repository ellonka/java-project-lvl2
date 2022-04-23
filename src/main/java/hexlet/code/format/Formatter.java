package hexlet.code.format;

public interface Formatter {
    void collect(String modification, String key, Object value);
    String print();
}
