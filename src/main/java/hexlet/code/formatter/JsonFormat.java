package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public final class JsonFormat implements Format {
    @Override
    public String prepareToPrint(List<Map<String, Object>> diff) {
        StringBuilder output = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Map<String, Object> map: diff) {
            try {
                output.append(objectMapper.writeValueAsString(map));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return output.toString();
    }
}
