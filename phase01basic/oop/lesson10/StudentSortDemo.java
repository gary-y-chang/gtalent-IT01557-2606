package phase01basic.oop.lesson10;

import java.util.*;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("S002", "Bob",   92),
            new Student("S001", "Alice", 85),
            new Student("S004", "Diana", 92),
            new Student("S003", "Carol", 78)
        ));

        // ① Comparable 自然排序（成績降序）
        Collections.sort(list);
        System.out.println("自然排序（成績降序）：");
        list.forEach(System.out::println);

        // ② 依姓名排序
        list.sort(StudentComparators.BY_NAME);
        System.out.println("\n依姓名升序：");
        list.forEach(System.out::println);

        // ③ 多鍵排序
        list.sort(StudentComparators.BY_SCORE_THEN_NAME);
        System.out.println("\n多鍵（成績↓ → 姓名↑）：");
        list.forEach(System.out::println);

        // ④ TreeSet 自動維持依學號排序
        TreeSet<Student> byId = new TreeSet<>(StudentComparators.BY_ID);
        byId.addAll(list);

        // ⑤ findMax：成績最高的學生
        Student top = StudentComparators.findMax(list);
        System.out.println("\n最高分：" + top);
    }
}
