import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String []> lines = CSV.getLines("resources/unle.txt", "\t");
        List<String []> s = new ArrayList<>();
        List<String []> f = new ArrayList<>();

        for (String [] line: lines){
            try {
                if (line[2].equals("s")) {
                    s.add(line);
                }
                if (line[2].equals("f")) {
                    f.add(line);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.print(Arrays.toString(line));
                e.printStackTrace();
            }
        }

        Collections.shuffle(s);
        Collections.shuffle(f);

        List<String []> result = new ArrayList<>();
        int size = s.size();
        for (int i = 1; i <= size; i++) {
            result.add(f.get(0));
            f.remove(0);
            result.add(s.get(0));
            s.remove(0);
            if (i % 2 == 0){
                result.add(f.get(0));
                f.remove(0);
            }


        }
        Printer.toExcel("unle", result);
    }
}
