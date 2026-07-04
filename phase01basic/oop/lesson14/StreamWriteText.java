package phase01basic.oop.lesson14;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Traditional Character Streams (Best for Large Text Files)If you are dealing with massive text
 * files, reading the entire file into memory at once can cause an OutOfMemoryError. Use
 * BufferedReader and BufferedWriter to stream data line-by-line.
 */
public class StreamWriteText {
    public static void main(String[] args) {
        // Try-with-resources handles closing resources automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("large_output.txt"))) {
            writer.write("Streaming line 1");
            writer.newLine(); // Platform-independent newline character
            writer.write("Streaming line 2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
