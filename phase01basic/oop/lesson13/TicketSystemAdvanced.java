package phase01basic.oop.lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lesson 14 — Lab 1：多窗口售票系統（進階挑戰版）
 * ------------------------------------------------------------
 * 對應投影片「進階挑戰」提示：
 *   ① 改用 ReentrantLock 重寫（比 synchronized 更彈性）。
 *   ② 改用 AtomicInteger 重寫（無鎖 / lock-free 的原子操作）。
 *   ③ 加入 sleep 模擬售票延遲，讓執行緒交錯、競爭更明顯。
 *
 * 執行方式：
 *   javac TicketSystemAdvanced.java
 *   java  TicketSystemAdvanced lock     → 使用 ReentrantLock（預設）
 *   java  TicketSystemAdvanced atomic   → 使用 AtomicInteger
 */
public class TicketSystemAdvanced {

    /* ============================================================
     * 方式 ①：ReentrantLock
     *   - 手動 lock() / unlock()，務必把 unlock() 放進 finally，
     *     避免發生例外時鎖沒被釋放而造成死結。
     *   - 相較 synchronized，可支援 tryLock()、可中斷鎖、公平鎖等。
     * ============================================================ */
    static class LockSeller implements Runnable {
        private static int tickets = 100;
        private static final ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            while (true) {
                lock.lock();                    // 取得鎖
                try {
                    if (tickets <= 0) break;    // break 前 finally 仍會解鎖
                    simulateSelling();          // 模擬售票延遲（在鎖內，維持原子性）
                    System.out.printf("%s 售出第 %d 張，餘 %d%n",
                            Thread.currentThread().getName(), tickets--, tickets);
                } finally {
                    lock.unlock();              // ★ 一定要在 finally 釋放
                }
            }
        }

        static int remaining() { return tickets; }
    }

    /* ============================================================
     * 方式 ②：AtomicInteger（無鎖）
     *   - decrementAndGet() 是原子操作，底層用 CAS 實作。
     *   - 先「預扣」一張票號，若 >= 0 才算售出，避免超賣。
     *   - 適合「單一計數器」的場景；若要保護多個變數的一致性，
     *     仍建議用鎖。
     * ============================================================ */
    static class AtomicSeller implements Runnable {
        private static final AtomicInteger tickets = new AtomicInteger(100);

        @Override
        public void run() {
            while (true) {
                int ticketNo = tickets.getAndDecrement();  // 原子取號並遞減
                if (ticketNo <= 0) break;                  // 已無票，收工
                simulateSelling();
                System.out.printf("%s 售出第 %d 張，餘 %d%n",
                        Thread.currentThread().getName(), ticketNo, ticketNo - 1);
            }
        }

        static int remaining() { return Math.max(tickets.get(), 0); }
    }

    /** 模擬售票需要一點處理時間，放大競爭窗口。 */
    private static void simulateSelling() {
        try {
            Thread.sleep((long) (Math.random() * 5));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /* ============================================================ */
    public static void main(String[] args) throws InterruptedException {
        String mode = args.length > 0 ? args[0].toLowerCase() : "lock";
        boolean useAtomic = mode.equals("atomic");
        System.out.println("=== 售票模式：" + (useAtomic ? "AtomicInteger（無鎖）" : "ReentrantLock") + " ===");

        Runnable job = useAtomic ? new AtomicSeller() : new LockSeller();

        List<Thread> windows = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Thread t = new Thread(job, "窗口-" + i);
            windows.add(t);
            t.start();
        }
        for (Thread t : windows) t.join();

        int left = useAtomic ? AtomicSeller.remaining() : LockSeller.remaining();
        System.out.printf("=== 全部售完，剩餘票數 = %d ===%n", left);
    }
}
