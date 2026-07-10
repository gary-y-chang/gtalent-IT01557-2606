package phase01basic.oop.lesson13;

public class SharedBufferV1 {
    
    private volatile int numberOfBread = 0; // 盤子裡的麵包數量（一開始盤子是空的）
   
    // 生產者呼叫的方法
    public synchronized void produce() {
        while (numberOfBread > 0 ) { // 1. 盤子有麵包，生產者可以休息一下
            try {
                System.out.println(Thread.currentThread().getName() + " 看到麵包數量大於 0，開始等待...");
                wait(); 
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println("生產者看到麵包數量: " + numberOfBread);
        // 2. 執行生產
        numberOfBread++;
        System.out.println(Thread.currentThread().getName() + " 製作了一個麵包。");
        
        // 3. 通知(喚醒)其他執行緒（消費者 + 生產者）
        notifyAll(); 
    }

    // 消費者呼叫的方法
    public synchronized void consume() {
        while (numberOfBread < 1 ) { // 1. 盤子沒有麵包，消費者必須等待
            try {
                System.out.println(Thread.currentThread().getName() + " 看到盤子空了，開始等待...");
                wait(); 
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println(Thread.currentThread().getName() +" 看到麵包數量: " + numberOfBread);
        // 2. 執行消費
        numberOfBread--;
        System.out.println(Thread.currentThread().getName() + " 吃掉了麵包。");
        
        // 3. 通知其他執行緒（生產者）
        notifyAll(); 
    }
}


