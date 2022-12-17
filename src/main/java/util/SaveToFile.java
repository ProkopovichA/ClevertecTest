package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToFile {
    public static void saveListToFile(String fileName, List<String> printArr) {
        //final String fileName = "SampleText.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : printArr) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
