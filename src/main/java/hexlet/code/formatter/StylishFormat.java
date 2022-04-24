package hexlet.code.formatter;

public final class StylishFormat implements Format {
    private StringBuilder result;

    public StylishFormat() {
        result = new StringBuilder("{\n");
    }

    @Override
    public void collectData(String modification, String key, Object value1, Object value2) {
        switch (modification) {
            case "ADDED" -> result.append("  + " + key + ": " + value2 + "\n");
            case "DELETED" -> result.append("  - " + key + ": " + value1 + "\n");
            case "UNCHANGED" -> result.append("    " + key + ": " + value1 + "\n");
            case "UPDATED" -> result.append("  - " + key + ": " + value1 + "\n"
                                + "  + " + key + ": " + value2 + "\n");
            default -> result.append("");
        }
    }

    @Override
    public String prepareToPrint() {
        result.append("}");
        return result.toString();
    }
}
