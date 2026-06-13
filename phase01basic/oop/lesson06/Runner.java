public class Runner {
    public static void main(String[] args) {

        RecordCar car = new RecordCar("Toyota", 2024, 850000.0);

        // accessor 命名直接用欄位名，不加 get 前綴
        System.out.println(car.brand());   // Toyota
        System.out.println(car.year());    // 2024
        System.out.println(car.price());   // 850000.0

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
    }
}
