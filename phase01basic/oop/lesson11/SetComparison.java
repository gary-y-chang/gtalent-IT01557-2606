package phase01basic.oop.lesson11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetComparison {
    public static void main(String[] args) {

        // 準備相同的測試資料（刻意亂序且包含重複值）
        int[] numbers = {40, 10, 30, 20, 10};

        // // ---- 1. HashSet (無序、速度最快) ----
        // Set<Integer> hashSet = new HashSet<>();
        // for (int num : numbers)
        //     hashSet.add(num);

        // System.out.println("HashSet 輸出 (無序)       : " + hashSet);
        // 輸出順序是不可預測的（由 Hash 碼決定，且自動去重）
        // 範例輸出: [20, 40, 10, 30]

        // ---- 2. TreeSet (自動排序、二元樹結構) ----
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : numbers){
            treeSet.add(num);
        }

        System.out.println("TreeSet 輸出 (由小到大)    : " + treeSet);
        // 輸出順序必定是由小到大（自然排序）
        // 輸出: [10, 20, 30, 40]
        Set<Integer> subSet = treeSet.headSet(30);
        System.out.println("TreeSet 輸出 (小於 30)      : " + subSet);

        // // ---- 3. LinkedHashSet (維持插入順序) ----
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int num : numbers)
            linkedHashSet.add(num);
        System.out.println("LinkedHashSet 輸出 (依輸入): " + linkedHashSet);
        // 輸出順序必定與我們 add 的順序一模一樣（重複的 10 會被忽略）
        // 輸出: [40, 10, 30, 20]
    }
}
