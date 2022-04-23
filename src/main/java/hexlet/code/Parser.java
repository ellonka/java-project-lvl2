package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws IOException {
        String data = Files.readString(Paths.get(filePath).toAbsolutePath());
        TypeReference<Map<String, Object>> token = new TypeReference<>() {
        };
        String fileType = determineFileType(filePath);

        JsonFactory factory = switch (fileType) {
            case "json" -> new JsonFactory();
            case "yml" -> new YAMLFactory();
            default -> throw new IllegalArgumentException("This format isn't supported");
        };
        ObjectMapper mapper = new ObjectMapper(factory);
        return mapper.readValue(data, token);
    }

    public static String determineFileType(String filePath) {
        if (filePath.lastIndexOf(".") != 0) {
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        }
        return "";
    }
}

