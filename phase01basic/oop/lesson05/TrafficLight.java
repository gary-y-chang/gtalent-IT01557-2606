package phase01basic.oop.lesson05;

/**
 * Lesson 05 — Lab 03 參考解答 Enum 列舉：TrafficLight 紅綠燈
 */
public enum TrafficLight {

    // 定義三個常數，傳入中文名稱與亮燈秒數
    STOP("紅燈", 30), CAUTION("黃燈", 5), GO("綠燈", 25);

    // 自訂欄位
    private final String label;
    private final int seconds;

    // 建構子（enum 建構子預設為 private）
    TrafficLight(String label, int seconds) {
        this.label = label;
        this.seconds = seconds;
    }

    // Getter 方法
    public String getLabel() {
        return label;
    }

    public int getSeconds() {
        return seconds;
    }

    // 描述方法
    public void describe() {
        System.out.println(label + " 亮燈 " + seconds + " 秒");
    }

    public static void main(String[] args) {

        // ── 1. values() 迴圈印出所有燈號 ──────────────────────────
        System.out.println("=== 所有燈號 ===");
        for (TrafficLight light : TrafficLight.values()) {
            light.describe();
        }
        // 預期輸出：
        // 紅燈 亮燈 30 秒
        // 黃燈 亮燈 5 秒
        // 綠燈 亮燈 25 秒

        System.out.println();

        // ── 2. 內建方法示範 ───────────────────────────────────────
        System.out.println("=== 內建方法 ===");
        System.out.println(TrafficLight.GO.name()); // "GO"
        System.out.println(TrafficLight.GO.ordinal()); // 2
        System.out.println(TrafficLight.GO.getLabel()); // "綠燈"
        System.out.println(TrafficLight.GO.getSeconds()); // 25

        TrafficLight found = TrafficLight.valueOf("STOP");
        System.out.println(found.getLabel()); // "紅燈"

        System.out.println();

        // ── 3. switch 搭配 ────────────────────────────────────────
        System.out.println("=== switch 判斷 ===");
        TrafficLight current = TrafficLight.STOP;
        switch (current) {
            case STOP:
                System.out.println("請停車");
                break;
            case CAUTION:
                System.out.println("注意，準備停車");
                break;
            case GO:
                System.out.println("可以通行");
                break;
        }
    }
}
