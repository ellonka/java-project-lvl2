package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class JsonFormat implements Format {
    private Map<String, Map<String, Object>> result;

    public JsonFormat() {
        result = new TreeMap<>();
    }

    @Override
    public void collectData(String modification, String key, Object value1, Object value2) {
        result.put(key, new HashMap<>() {{
                    put(" - ", value1);
                    put(" + ", value2);
                }});
    }

    @Override
    public String prepareToPrint() {
        StringBuilder output = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            output.append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
