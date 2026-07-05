package phase01basic.oop.lesson11;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapComparison {
    public static void main(String[] args) {

        // 準備測試資料：故意亂序放入 (Key 是學號，Value 是姓名)
        // 放入順序: 4 -> 1 -> 3 -> 2

        // ---- 1. HashMap (無序、速度最快) ----
        // Map<Integer, String> hashMap = new HashMap<>();
        // hashMap.put(4, "David");
        // hashMap.put(1, "Alice");
        // hashMap.put(3, "Charlie");
        // hashMap.put(2, "Bob");
        // System.out.println("HashMap 輸出 (無序)       : " + hashMap);
        // 輸出順序是不可預測的（由 Hash 碼決定）

        // ---- 2. TreeMap (依 Key 自動排序、紅黑樹結構) ----
        //TreeMap<Integer, String> treeMap = new TreeMap<>();
        // treeMap.put(40, "David");
        // treeMap.put(10, "Alice");
        // treeMap.put(30, "Charlie");
        // treeMap.put(20, "Bob");
        // TreeMap<String, Integer> treeMap = new TreeMap<>();
        // treeMap.put("David", 40);
        // treeMap.put("Alice", 10);
        // treeMap.put("Charlie", 30); 
        // treeMap.put("Bob", 20);
        // System.out.println("TreeMap 輸出 (依 Key 排序) : " + treeMap);
        // // Key 必定會依數字由小到大排序 (1 -> 2 -> 3 -> 4)
        // String key = treeMap.floorKey("Bpwt");  
        // System.out.println("TreeMap's floor key 輸出 (最小 Key)    : " + key);

        // ---- 3. LinkedHashMap (維持 Key 插入順序) ----
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, "David");
        linkedHashMap.put(1, "Alice");
        linkedHashMap.put(3, "Charlie");
        linkedHashMap.put(2, "Bob");
        System.out.println("LinkedHashMap 輸出 (依插入): " + linkedHashMap);
        // 輸出順序必定與 put 的順序完全相同 (4 -> 1 -> 3 -> 2)
    }
}
