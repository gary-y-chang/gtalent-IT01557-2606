package phase01basic.oop.lesson13;

public class DaemonExample {
    public static void main(String[] args) {
        
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("背景守護執行緒正在運作中...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        // 必須在 start() 之前設定
        daemonThread.setDaemon(true); 
        daemonThread.start();

        // 主執行緒（User Thread）只執行 2 秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("主執行緒（User Thread）結束了！");
        // 此時沒有任何 User Thread 了，JVM 會直接終止，Daemon Thread 也會瞬間被抽離而停止。
    }
}
