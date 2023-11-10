import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAggregator {
    private FileParserContext parserContext = new FileParserContext();

    public List<String> aggregateData(Map<String, FileParser> parsers, List<String> filePaths) throws IOException {
        List<String> aggregatedData = new ArrayList<>();
        for (String filePath : filePaths) {
            String fileExtension = getFileExtension(filePath);
            parserContext.setFileParser(parsers.get(fileExtension));
            aggregatedData.addAll(parserContext.parse(filePath));
        }
        return aggregatedData;
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
