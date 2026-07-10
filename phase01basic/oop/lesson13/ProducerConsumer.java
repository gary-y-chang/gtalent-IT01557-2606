package phase01basic.oop.lesson13;

public class ProducerConsumer {
    public static void main(String[] args) {
        // SharedBufferV1 buffer = new SharedBufferV1();
        SharedBufferV2 buffer = new SharedBufferV2();

        // long delayMillis = 500; // 每次生產/消費之間稍作停頓，方便觀察輸出

        // 建立生產者執行緒：不斷地生產麵包
        Thread producer = new Thread(() -> {
            while (true) {
                buffer.produce();
                sleep(3000);
            }
        }, "Producer");

        // 建立兩個消費者執行緒：不斷地吃麵包
        Thread consumer1 = new Thread(() -> {
            while (true) {
                buffer.consume();
                sleep(9000);
            }
        }, "Consumer-1");

        Thread consumer2 = new Thread(() -> {
            while (true) {
                buffer.consume();
                sleep(9000);
            }
        }, "Consumer-2");

        consumer1.start();
        consumer2.start();
        producer.start();
    }

    // 讓執行緒暫停一段時間（毫秒）
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
