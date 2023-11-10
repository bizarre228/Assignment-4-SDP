import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public interface FileParser {
    List<String> parseFile(String filePath) throws IOException;
}
class TxtFileParser implements FileParser {
    public List<String> parseFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

class CsvFileParser implements FileParser {
    public List<String> parseFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

class JsonFileParser implements FileParser {
    public List<String> parseFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

class FileParserContext {
    private FileParser fileParser;

    public void setFileParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public List<String> parse(String filePath) throws IOException {
        return fileParser.parseFile(filePath);
    }
}
