import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> filePaths = Arrays.asList(
                    "src\\example.txt",
                    "src\\example2.csv",
                    "src\\example3.json"
            );

            Map<String, FileParser> parsing = new HashMap<>();
            parsing.put("txt", new TxtFileParser());
            parsing.put("csv", new CsvFileParser());
            parsing.put("json", new JsonFileParser());

            DataAggregator aggregator = new DataAggregator();
            List<String> aggregatedData = aggregator.aggregateData(parsing, filePaths);

            aggregatedData.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
