package phase01basic.oop.lesson13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 1. 建立一個固定大小為 3 的執行緒池 (ExecutorService)
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. 定義一個 Callable 任務 (計算 1~100 的總和，並回傳 Integer)
        Callable<Integer> sumTask = () -> {
            System.out.println(Thread.currentThread().getName() + " 開始計算...");
            Thread.sleep(1500); // 模擬耗時的計算
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        };

        Callable<Integer> sumTask2 = () -> {
            System.out.println(Thread.currentThread().getName() + " 開始計算...");
            Thread.sleep(1500); // 模擬耗時的計算
            int sum = 0;
            for (int i = 1; i <= 200; i++) {
                sum += i;
            }
            return sum;
        };

        try {
            System.out.println("主執行緒：提交任務到執行緒池");

            // 3. 提交任務，ExecutorService 會「立刻」回傳一個 Future 物件 (不會阻塞)
            Future<Integer> futureResult = pool.submit(sumTask);
            Future<Integer> futureResult2 = pool.submit(sumTask2);

            System.out.println("主執行緒：去做其他事情...");
            Thread.sleep(500); // 模擬主執行緒在忙別的事

            System.out.println("主執行緒：準備獲取結果（若任務未完成，此處會阻塞等待）");

            // 4. 呼叫 get() 取得結果。如果子執行緒還沒算完，主執行緒會在這裡原地等待
            Integer finalResult = futureResult.get();
            System.out.println("最終計算結果為: " + finalResult); // 輸出 5050

            Integer finalResult2 = futureResult2.get();
            System.out.println("最終計算結果為: " + finalResult2); // 輸出 10050

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 務必關閉執行緒池，否則 JVM 程式不會結束！
            pool.shutdown();
        }
    }
}
