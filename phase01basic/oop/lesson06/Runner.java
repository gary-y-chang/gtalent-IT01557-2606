package phase01basic.oop.lesson06;

public class Runner {
    public static void main(String[] args) {

        // Car car = new Car("Toyota", 2000, 150000.0);
        // System.out.println(car);

        RecordCar car = new RecordCar("Toyota", 2024, 850000.0);
        RecordCar car2 = new RecordCar(); // 使用無參數建構子
        System.out.println(car2); // Car[brand=Unknown, year=2024, price=0.0]

        // accessor 命名直接用欄位名，不加 get 前綴
        System.out.println(car.brand()); // Toyota
        System.out.println(car.year()); // 2024
        System.out.println(car.price()); // 850000.0

        // toString() 自動生成
        System.out.println(car);
        // 輸出：Car[brand=Toyota, year=2024, price=850000.0]

        // equals() 自動按欄位值比較
        RecordCar c2 = new RecordCar("Toyota", 2024, 850000.0);
        System.out.println(car.equals(c2)); // true

        // 驗證：非法年份
        try {
            new RecordCar("Unknown", 1800, 0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("例外：" + e.getMessage()); // 年份無效
        }

        // 驗證：負價格
        try {
            new RecordCar("Tesla", 2024, -1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("例外：" + e.getMessage()); // 價格不能為負
        }

        // Employee emp1 = new Employee();
        // Employee emp2 = new Employee("E001", "Alice");
        // Employee emp3 = new Employee("E002", 75000);
        // Employee emp4 = new Employee("E003", "Bob", "IT", 90000);

        RecordOrder emptyOrder = RecordOrder.EMPTY_ORDER; // 使用空物件模式
        System.out.println(emptyOrder); // RecordOrder[id=NONE, amount=0.0]

        // Example of TransactionDto
        // 收到前端資料
        String id = "TX1001";
        String amountStr = "1500.50";
        String timeStr = "2026-06-22 23:45:00";

        // 使用靜態工廠，不需要在 Controller 寫髒亂的解析邏輯
        TransactionDto dto = TransactionDto.fromRequest(id, amountStr, timeStr);
        System.out.println(dto); // TransactionDto[id=TX1001, amount=1500.50,
                                 // timestamp=2026-06-22T23:45]

        // 程式碼可讀性極高，一眼就能看出業務意圖
        Discount happyHour = Discount.percentage(20); // 打八折
        Discount memberBonus = Discount.fixedAmount(100); // 折 100 元

        int discountType = happyHour.type().equals("PERCENTAGE") ? 1 : 2; 


    }
}
