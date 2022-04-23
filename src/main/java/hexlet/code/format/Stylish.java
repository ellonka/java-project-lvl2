package hexlet.code.format;

public final class Stylish implements Formatter {
    private StringBuilder result;

    public Stylish() {
        result = new StringBuilder("{\n");
    }

    @Override
    public void collect(String modification, String key, Object value) {
        switch (modification) {
            case "ADDED" -> result.append(" + " + key + ": " + value + "\n");
            case "DELETED" -> result.append(" - " + key + ": " + value + "\n");
            case "UNCHANGED" -> result.append("   " + key + ": " + value + "\n");
            default -> result.append("");
        }
    }

    @Override
    public String print() {
        result.append("}");
        return result.toString();
    }
}
