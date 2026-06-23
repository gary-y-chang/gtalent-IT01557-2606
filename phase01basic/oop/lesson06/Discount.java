package phase01basic.oop.lesson06;

public record Discount(String type, double value) {

    /**
     * 靜態工廠方法 1：創建「百分比折扣」
     */
    public static Discount percentage(double rate) {
        if (rate <= 0 || rate > 100) {
            throw new IllegalArgumentException("折扣比例必須在 0 到 100 之間");
        }
        return new Discount("PERCENTAGE", rate);
    }

    /**
     * 靜態工廠方法 2：創建「固定金額折抵」
     */
    public static Discount fixedAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("折抵金額不能為負數");
        }
        return new Discount("FIXED", amount);
    }
}

