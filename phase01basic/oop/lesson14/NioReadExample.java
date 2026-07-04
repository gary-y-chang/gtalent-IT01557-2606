package phase01basic.oop.lesson14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The java.nio.file.Files class provides simple, one-line methods to read and write files without
 * manually managing buffers or streams.
 */
public class NioReadExample {
    public static void main(String[] args) {
        Path path = Paths.get("output.txt");

        try {
            // Reads the entire file into memory as a list of strings
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Could not read file: " + e.getMessage());
        }
    }
}
