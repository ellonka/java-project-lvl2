package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileProcessing {
    public static Map<String, Object> extractMapFromFile(String filePath) throws IOException {
        String data = readData(filePath);
        String fileType = determineFileType(filePath);
        return Parser.parse(data, fileType);
    }

    private static String readData(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath).toAbsolutePath());
    }

    private static String determineFileType(String filePath) {
        if (filePath.lastIndexOf(".") != 0) {
            return filePath.substring(filePath.lastIndexOf(".") + 1);
        }
        return "";
    }
}
