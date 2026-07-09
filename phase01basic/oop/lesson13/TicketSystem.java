package phase01basic.oop.lesson13;

import java.util.ArrayList;
import java.util.List;

/**
 * Lesson 14 — Lab 1：多窗口售票系統（基礎版） ------------------------------------------------------------
 * 情境：多個售票窗口（執行緒）同時販售「共用的 100 張票」。
 *
 * 本檔完整示範兩件事： 1. 為什麼「未同步」會發生競爭條件（超賣、餘 -1、重複售出）。 2. 用 synchronized 同步區塊修正，確保總售出張數正好 100。
 *
 * 執行方式： javac TicketSystem.java java TicketSystem → 執行「安全版」（預設） java TicketSystem unsafe →
 * 執行「危險版」，觀察競爭條件
 */
public class TicketSystem {

    /*
     * ============================================================ 售票任務：實作 Runnable，讓多條執行緒「共用同一個
     * job 物件」， 因此票庫 tickets 與鎖 lock 都宣告為 static（全類別共享一份）。
     * ============================================================
     */
    static class TicketSeller implements Runnable {

        private static int tickets = 100; // 共享票庫
        private static final Object lock = new Object(); // 專用鎖物件
        private final boolean safe; // 是否啟用同步

        TicketSeller(boolean safe) {
            this.safe = safe;
        }

        @Override
        public void run() {
            while (true) {
                if (safe) {
                    // ✅ 安全版：把「檢查餘票 + 賣票」包在同一個同步區塊，
                    // 確保這段是原子操作，同一時間只有一條緒能進入。
                    // 加一點延遲，放大執行緒交錯的時間窗，讓競爭條件更容易重現。
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    synchronized (lock) {
                        if (tickets <= 0)
                            break;
                        sell();
                    }
                } else {
                    // ❌ 危險版：檢查與賣票沒有一起鎖住，
                    // 兩條緒可能同時通過 if 判斷，造成超賣。
                    if (tickets <= 0)
                        break;
                    sell();
                }
            }
        }

        /** 賣出一張票並印出窗口與餘票。 */
        private void sell() {
            // try {
            // Thread.sleep(5000);
            // } catch (InterruptedException e) {
            // Thread.currentThread().interrupt();
            // }

            System.out.printf("%s 售出第 %d 張，餘 %d%n", Thread.currentThread().getName(), tickets--,
                    tickets);
        }

        static int remaining() {
            return tickets;
        }
    }

    /* ============================================================ */
    public static void main(String[] args) throws InterruptedException {
        boolean safe = !(args.length > 0 && args[0].equalsIgnoreCase("unsafe"));
        System.out.println("=== 售票模式：" + (safe ? "安全版 (synchronized)" : "危險版 (未同步)") + " ===");

        // 所有窗口共用同一個 job 物件 → 共用同一份 static 票庫
        TicketSeller job = new TicketSeller(safe);

        List<Thread> windows = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Thread t = new Thread(job, "窗口-" + i);
            windows.add(t);
            t.start();
        }

        // 主執行緒用 join 等待 4 個窗口全部收工，再印出總結。
        for (Thread t : windows)
            t.join();

        System.out.printf("=== 結束，剩餘票數 = %d ===%n", TicketSeller.remaining());
        System.out.println(safe ? "安全版：剩餘應為 0，且沒有超賣。" : "危險版：可能出現「餘 -1」「同一張票賣兩次」等錯誤，這就是競爭條件。");
    }
}
