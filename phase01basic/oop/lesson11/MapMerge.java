package phase01basic.oop.lesson11;

import java.util.HashMap;
import java.util.Map;

public class MapMerge {
    public static void main(String[] args) {

        Map<String, Integer> counts = new HashMap<>();
        counts.put("Apple", 1);
        counts.put("Banana", 2);

        // ❌ 傳統舊寫法
        if (counts.get("Apple") == null) {
            counts.put("Apple", 1);
        } else {
            counts.put("Apple", counts.get("Apple") + 1);
        }

        // 換成 merge() 只要一行（使用方法參照 Integer::sum）
        // 如果 "Apple" 不存在，直接存入 1；如果存在，就把「舊值」加上「新值（1）
        counts.merge("Apple", 1, Integer::sum);

        Map<String, String> userRoles = new HashMap<>();
        userRoles.put("Alice", "ADMIN");

        // 合併 Alice 的新權限
        userRoles.merge("Alice", "USER", (oldVal, newVal) -> oldVal + ", " + newVal);

        System.out.println(userRoles.get("Alice")); // 輸出: ADMIN, USER

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 30);
        map2.put("C", 40);

        // 將 map2 合併至 map1，若 Key 重複則將數值相加
        map2.forEach((key, val) -> map1.merge(key, val, Integer::sum));

        System.out.println(map1); // 輸出: {A=10, B=50, C=40}

    }

}
