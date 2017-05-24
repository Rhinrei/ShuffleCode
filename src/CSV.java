import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static List<String []> getLines(String filePath, String delimeter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String []> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null){
            lines.add(line.split(delimeter));
            line = reader.readLine();
        }
        return lines;
    }
}
