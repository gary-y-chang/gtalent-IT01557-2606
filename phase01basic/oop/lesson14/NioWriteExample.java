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
public class NioWriteExample {
    public static void main(String[] args) {
        Path path = Paths.get("output.txt");
        List<String> lines = List.of("First line", "Second line", "Third line");

        try {
            // Creates the file or overwrites it if it already exists
            Files.write(path, lines);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
