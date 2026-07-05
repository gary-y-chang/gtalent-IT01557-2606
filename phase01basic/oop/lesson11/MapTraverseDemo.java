package phase01basic.oop.lesson11;

import java.util.HashMap;
import java.util.Map;

public class MapTraverseDemo {
    public static void main(String[] args) {
        
        // 準備測試 Map 資料
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 50);
        items.put("Banana", 30);
        items.put("Cherry", 80);

        // ---- 1. 使用 for-each 遍歷 entrySet()【最推薦：同時需要 Key 和 Value】 ----
        System.out.println("--- 1. entrySet() 走訪 ---");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("品名: " + entry.getKey() + ", 價格: " + entry.getValue());
        }

        // ---- 2. 使用 Java 8 Lambda / forEach()【最簡潔：程式碼最少】 ----
        System.out.println("\n--- 2. Lambda forEach 走訪 ---");
        items.forEach((k, v) -> {
            System.out.println("品名: " + k + ", 價格: " + v);
        });

        // ---- 3. 只遍歷 keySet() 或 values()【特定需求：只要單一欄位】 ----
        System.out.println("\n--- 3. 只走訪 Key 或 Value ---");
        // 只拿所有 Key
        for (String key : items.keySet()) {
            System.out.println("僅 Key: " + key);
        }
        // 只拿所有 Value
        for (Integer value : items.values()) {
            System.out.println("僅 Value: " + value);
        }

        items.remove("Apple"); // 移除 Key
        items.remove(Integer.valueOf(50)); // 移除 Value
        items.clear(); // 清空 Map

        // ---- 4. 使用 Iterator 走訪【進階：需要在走訪時「安全刪除」元素】 ----
        System.out.println("\n--- 4. Iterator 走訪 (安全刪除演示) ---");
        var iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getKey().equals("Banana")) {
                iterator.remove(); // 在走訪過程中安全地移除 Banana，不會拋出異常
                System.out.println("已移除 Banana");
            }
        }
        System.out.println("剩餘 Map 內容: " + items);
    }
}
