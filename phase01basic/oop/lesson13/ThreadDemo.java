package phase01basic.oop.lesson13;

import java.util.List;
import java.util.ArrayList;

public class ThreadDemo {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(9);
        list.add(5);
        list.add(10);
        list.add(8);
        list.add(7);

        Counter counter = new Counter();


        System.out.println("=== 主執行緒開始 ===");

        // 1. 建立執行緒 A (展示 yield)
        Thread threadA = new Thread(() -> { // new Runnable(){ .....
            // for (int i = 1; i <= 3; i++) {
            // System.out.println(Thread.currentThread().getName() + " i=" + i);
            // if (i == 2) {
            // System.out.println(">> " + Thread.currentThread().getName() + " 執行 yield()");
            // Thread.yield(); // 提示讓出 CPU
            // }
            // }
            // list.sort(Integer::compareTo);

            for (int i = 0; i < 100; i++) {
                try {
                     counter.inc();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
                System.out.println(Thread.currentThread().getName() + " i=" + i);
            }

        }, "Thread-A");

        // 2. 建立執行緒 B (展示 sleep)
        Thread threadB = new Thread(() -> {
            // try {
            //     System.out.println(Thread.currentThread().getName() + " 開始休眠 10s");
            //     Thread.sleep(10000);
            //     System.out.println(Thread.currentThread().getName() + " 休眠結束");
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            // list.sort(Integer::compareTo);

             for (int i = 0; i < 100; i++) {
                 try {
                     counter.inc();
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " i=" + i);
            }
        }, "Thread-B");

        threadA.start();
        threadB.start();

        // 3. 展示 join()
        try {
            threadA.join(); // 主執行緒等待 A 完成
            threadB.join(); // 主執行緒等待 B 完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== 主執行緒結束 ===");
        System.out.println(counter.count);
    }
}
