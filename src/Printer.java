import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Printer {
    public static void toExcel(String fileName, List<String []> strings){
        writeFile(fileName+".csv", processArray(strings, ";"));
    }

    public static void toText(String fileName, List<String []> strings){
        writeFile(fileName+".txt", processArray(strings, ";"));
    }

    private static void writeFile(String fileName, List<String> strings){
        try {
            Files.write(Paths.get(fileName), strings, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> processArray(List<String []> array, String separator){
        List<String> strings = new ArrayList<>();
        String fileLine = "";
        for (String [] line: array) {
            for (String s: line) {
                fileLine+=s + separator;
            }
            fileLine = fileLine.substring(0, fileLine.length() - separator.length());
            strings.add(fileLine);
            fileLine = "";
        }
        return strings;
    }
}
