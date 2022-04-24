package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String fileType) throws IOException {
        JsonFactory factory = switch (fileType) {
            case "json" -> new JsonFactory();
            case "yml" -> new YAMLFactory();
            default -> throw new IllegalArgumentException("This format isn't supported");
        };
        TypeReference<Map<String, Object>> token = new TypeReference<>() {
        };
        ObjectMapper mapper = new ObjectMapper(factory);
        return mapper.readValue(data, token);
    }
}

