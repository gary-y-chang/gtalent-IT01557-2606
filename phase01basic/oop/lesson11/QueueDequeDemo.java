package phase01basic.oop.lesson11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDequeDemo {
    public static void main(String[] args) {

        // ---- 1. Queue 範例 (先進先出 FIFO) ----
        Queue<String> queue = new LinkedList<>();

        // 進排隊 (尾端加入)
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // 看一眼排頭是誰 (不移除)
        System.out.println("Queue 排頭是: " + queue.peek()); // 輸出: A

        // 出排隊 (前端移除)
        System.out.println("Queue 移出: " + queue.poll()); // 輸出: A
        System.out.println("Queue 剩餘: " + queue); // 輸出: [B, C]


        // ---- 2. Deque 範例 (雙端操作) ----
        Deque<String> deque = new ArrayDeque<>();

        // 它可以當作 Queue 使用 (尾端加，前端拿)
        deque.addLast("中鋒");
        deque.addLast("前鋒");

        // 它也可以反過來操作 (前端加，尾端拿)
        deque.addFirst("後衛"); // 插隊到最前面

        System.out.println("Deque 目前陣容: " + deque);
        // 輸出: [後衛, 中鋒, 前鋒]

        // 兩端都能拆解
        System.out.println("移出最前面: " + deque.removeFirst()); // 輸出: 後衛
        System.out.println("移出最後面: " + deque.removeLast()); // 輸出: 前鋒
    }
}
