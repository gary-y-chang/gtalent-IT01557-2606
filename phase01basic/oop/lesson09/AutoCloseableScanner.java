package phase01basic.oop.lesson09;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class AutoCloseableScanner {

    public static void readFileContent(String filePath) {

        // 將 Scanner 宣告在 try 的括號內 ()
        // 只要離開 try 區塊（不論是正常結束還是發生異常），Java 都會自動呼叫 scanner.close()
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("找不到檔案: " + e.getMessage());
        }
        // 不需要寫 finally！資源已經被安全釋放。
    }

    public static void main(String[] args) {
        String currentPath = Paths.get("").toAbsolutePath().toString();
        readFileContent(currentPath + "/test.txt");
    }
}
