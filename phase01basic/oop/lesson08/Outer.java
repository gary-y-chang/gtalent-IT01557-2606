package phase01basic.oop.lesson08;

public class Outer {
    private static String staticMsg = "外部靜態變數";

    private String msg = "外部類別私有變數";

    public class Inner {
        public void print() {
            System.out.println(msg); // 直接存取
        }
    }

    public static class StaticInner {
        public void print() {
            System.out.println(staticMsg); // 直接存取
        }
    }

    public void startThread() {
        // 臨時實作 Runnable 介面
        Runnable r = new Runnable() {
            @Override
            public void run() { System.out.println("執行中"); }
        };
        
        new Thread(r).start();
    }
}
