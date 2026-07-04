package phase01basic.oop.lesson13;

import java.util.*;
import java.util.concurrent.*;

public class BatchProcessor {

    // 模擬處理一個檔案，回傳行數
    static int process(String filename) throws InterruptedException {
        Thread.sleep(100); // 模擬 I/O 延遲
        return new Random().nextInt(200) + 50;
    }

    public static void main(String[] args) throws Exception {
        List<String> files = List.of(
            "data1.txt", "data2.txt", "data3.txt",
            "data4.txt", "data5.txt");

        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (String f : files) {
            futures.add(pool.submit(() -> {
                int lines = process(f);
                System.out.printf("[%s] %s → %d 行%n",
                    Thread.currentThread().getName(), f, lines);
                return lines;
            }));
        }

        int total = 0;
        for (Future<Integer> ft : futures) total += ft.get();
        pool.shutdown();
        System.out.printf("=== %d 個檔案共處理 %d 行 ===%n", files.size(), total);
    }
}
