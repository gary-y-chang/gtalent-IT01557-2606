package phase01basic.oop.lesson11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("Java");
        c.add("JavaScript");
        c.add("C#");
        c.add("Python");
        c.add("Go");
        c.size(); // 3 — 元素數量
        c.contains("Java"); // true — 是否包含
        System.out.println(c.contains("C++")); // false
        c.isEmpty(); // false — 是否為空
        c.remove("Go");
        System.out.println(c);

        Collection<String> more = List.of("Java", "Kotlin"); // new ArrayList<>();

        c.addAll(more); // 加入整個集合
        System.out.println(c);

        c.retainAll(more); // 僅保留交集
        System.out.println(c);

        c.removeAll(more);
        System.out.println(c.isEmpty());
    }
}
