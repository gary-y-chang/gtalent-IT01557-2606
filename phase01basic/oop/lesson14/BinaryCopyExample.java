package phase01basic.oop.lesson14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Traditional Byte Streams (Best for Images, Audio, & Binary Data)When working with raw binary data
 * instead of plain text, use FileInputStream and FileOutputStream to manipulate raw byte arrays. 
 */
public class BinaryCopyExample {
    public static void main(String[] args) {
        String source = "input.jpg";
        String destination = "copy.jpg";

        try (FileInputStream in = new FileInputStream(source);
                FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096]; // 4KB chunk buffer
            int bytesRead;

            // Read raw bytes into buffer and write them directly to destination
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Binary file copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
