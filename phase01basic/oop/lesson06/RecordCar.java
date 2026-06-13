// Lab 03 — Car Record（參考解答）
// Lesson 06：封裝、建構子與 this
// Java 16+：將 JavaBean 改寫為 record（30 行 → 10 行）

public record RecordCar(String brand, int year, double price) {

    // 緊湊型建構子（Compact Constructor）— 只做驗證
    // JVM 自動完成 this.brand = brand; this.year = year; this.price = price;
    public RecordCar {
        if (year < 1886)
            throw new IllegalArgumentException("年份無效");
        if (price < 0)
            throw new IllegalArgumentException("價格不能為負");
    }

}
