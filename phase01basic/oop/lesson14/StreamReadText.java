package phase01basic.oop.lesson14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StreamReadText {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("large_output.txt"))) {
            String line;
            // Reads and prints one line at a time until reaching the end of file (null)
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
