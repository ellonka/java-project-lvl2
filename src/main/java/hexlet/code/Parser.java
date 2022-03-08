package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String filePath) {
        TypeReference<Map<String, Object>> token = new TypeReference<>() {
        };
        Map<String, Object> result = new HashMap<>();
        try {
            String data = extractData(filePath);
            if (filePath.endsWith(".json")) {
                result = parseFromJson(data, token);
            } else if (filePath.endsWith(".yml")) {
                result = parseFromYaml(data, token);
            } else {
                System.out.println("Файлы с таким расширением не обрабатываются");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String extractData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    private static Map<String, Object> parseFromJson(String data, TypeReference<Map<String, Object>> token)
            throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(data, token);
    }

    private static Map<String, Object> parseFromYaml(String data, TypeReference<Map<String, Object>> token)
            throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(data, token);
    }
}
