package phase01basic.oop.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService 範例：並行排序
 * ------------------------------------------------------------
 * 情境：用「大小為 4 的執行緒池」，同時對「6 個未排序的整數 List」進行排序。
 *
 * 觀察重點：
 *   1. 6 個任務 > 4 條執行緒 → 池會自動排隊、重用執行緒（看 thread 名稱會重複）。
 *   2. 每個排序任務用 Callable 包裝，回傳「已排序的 List」→ 透過 Future 收集。
 *   3. submit() 立即回傳 Future 不阻塞；future.get() 在收集階段才等待結果。
 *   4. 用完務必 shutdown()，否則 JVM 不會結束。
 *
 * 執行方式：
 *   javac SortWithThreadPool.java
 *   java  SortWithThreadPool
 */
public class SortWithThreadPool {

    /* ============================================================
     * 排序任務：實作 Callable<List<Integer>>，回傳排序後的清單。
     * ============================================================ */
    static class SortTask implements Callable<List<Integer>> {
        private final int id;
        private final List<Integer> data;

        SortTask(int id, List<Integer> data) {
            this.id = id;
            this.data = data;
        }

        @Override
        public List<Integer> call() {
            String worker = Thread.currentThread().getName();
            System.out.printf("[%s] 開始排序 List-%d：%s%n", worker, id, data);

            // 模擬耗時運算，讓 4 條緒與 6 個任務的排隊/重用更明顯
            try {
                Thread.sleep(300 + (long) (Math.random() * 400));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            List<Integer> sorted = new ArrayList<>(data);
            Collections.sort(sorted);   // 升冪排序

            System.out.printf("[%s] 完成排序 List-%d：%s%n", worker, id, sorted);
            return sorted;
        }
    }

    /* ============================================================ */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 6 個未排序的整數 List
        List<List<Integer>> datasets = List.of(
                Arrays.asList(5, 2, 9, 1, 7),
                Arrays.asList(42, 8, 15, 4),
                Arrays.asList(100, 50, 75, 25, 60, 10),
                Arrays.asList(3, 3, 1, 2, 1),
                Arrays.asList(88, 12, 34, 56, 78),
                Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1)
        );

        // 1. 建立大小為 4 的執行緒池
        ExecutorService pool = Executors.newFixedThreadPool(4);

        // 2. 提交 6 個排序任務，收集對應的 Future
        // List<Future<List<Integer>>> futures = new ArrayList<>();
        // for (int i = 0; i < datasets.size(); i++) {
        //     futures.add(pool.submit(new SortTask(i + 1, datasets.get(i))));
        // }

        List<Callable<List<Integer>>> tasks = new ArrayList<>();
        for (int i = 0; i < datasets.size(); i++) {
            tasks.add(new SortTask(i + 1, datasets.get(i)));
        }
        List<Future<List<Integer>>> futures = pool.invokeAll(tasks);

        // 3. 依序取回結果（get() 會阻塞至各任務完成）
        System.out.println("\n===== 所有排序結果 =====");
        for (int i = 0; i < futures.size(); i++) {
            List<Integer> sorted = futures.get(i).get();
            System.out.printf("List-%d 排序後：%s%n", i + 1, sorted);
        }

        // 4. 關閉執行緒池並等待收尾
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("===== 全部完成，執行緒池已關閉 =====");
    }
}
