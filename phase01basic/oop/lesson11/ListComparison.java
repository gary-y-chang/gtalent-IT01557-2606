package phase01basic.oop.lesson11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args) {

        // ---- 1. ArrayList 範例 ----
        // 底層是連續的陣列，適合頻繁讀取
        List<String> arrayList = new ArrayList<>();

        // 新增元素 (預設加到尾端)
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        // 隨機存取 (透過 Index 讀取速度極快)
        String secondFruit = arrayList.get(1);
        System.out.println("ArrayList 索引 1 的元素: " + secondFruit); // 輸出: Banana

        // ---- 2. LinkedList 範例 ----
        // 底層是節點與指標，適合頻繁在頭尾新增/刪除
        // 這裡改用 LinkedList 宣告，以便使用 Queue/Deque 的獨有方法
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        // LinkedList 特有操作：在最前端或最末端插入/刪除元素 (時間複雜度為 O(1))
        linkedList.addFirst("Mango"); // 插到最前面
        linkedList.addLast("Orange"); // 插到最後面

        System.out.println("LinkedList 目前內容: " + linkedList);
        // 輸出: [Mango, Apple, Banana, Cherry, Orange]

        // ---- 3. 效能對比操作演示 ----

        // 缺點示範：ArrayList 在中間插入元素很慢（後面所有元素都要往後搬移）
        arrayList.add(1, "Blueberry");

        // 缺點示範：LinkedList 讀取中間元素很慢（必須從頭或尾一個一個節點數過去）
        String middleFruit = linkedList.get(2);
    }
}
