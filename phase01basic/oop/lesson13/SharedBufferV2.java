package phase01basic.oop.lesson13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedBufferV2 {
    
    private final Lock lock = new ReentrantLock();
    
    // 透過同一個鎖，建立兩個不同的等待佇列（分流管理，效率更高）
    private final Condition producerWaitZone = lock.newCondition();  // 生產者等待區
    private final Condition consumerWaitZone = lock.newCondition(); // 消費者等待區
    
    private boolean hasData = false;

    public void produce() {
        lock.lock(); // 手動加鎖
        try {
            while (hasData) {
                System.out.println(Thread.currentThread().getName() + " 發現盤子滿了，去 producerWaitZone 區等待...");
                producerWaitZone.await(); // 生產者去自己的等待區，並釋放鎖
            }
            hasData = true;
            System.out.println(Thread.currentThread().getName() + " 製作了一個麵包。");
            
            consumerWaitZone.signal(); // 喚醒在消費者等待區的「消費者」
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 務必在 finally 釋放鎖，防止死結
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (!hasData) {
                System.out.println(Thread.currentThread().getName() + " 發現盤子空了，去 consumerWaitZone 區等待...");
                consumerWaitZone.await(); // 消費者去自己的等待區，並釋放鎖
            }
            hasData = false;
            System.out.println(Thread.currentThread().getName() + " 吃掉了麵包。");
            
            producerWaitZone.signal(); // 喚醒在生產者等待區的「生產者」，不用像 notifyAll 叫醒所有人
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
