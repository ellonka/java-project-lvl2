package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public interface Format {
    String prepareToPrint(List<Map<String, Object>> diff);
}
