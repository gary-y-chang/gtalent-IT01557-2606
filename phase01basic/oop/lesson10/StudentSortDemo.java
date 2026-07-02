package phase01basic.oop.lesson10;

import java.time.LocalDate;
import java.util.*;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("S002", "Bob",   92, LocalDate.parse("1989-02-25")),
            new Student("S001", "Alice", 85, LocalDate.parse("1991-05-15")),
            new Student("S004", "Diana", 92, LocalDate.parse("1990-01-28")),
            new Student("S003", "Carol", 78, LocalDate.parse("1989-07-04"))
        ));

        // ① Comparable 自然排序（成績降序）
        Collections.sort(list);
        System.out.println("自然排序（成績降序）：");
        list.forEach(System.out::println);

        // ② 依姓名排序
        list.sort(StudentComparators.BY_NAME);
        System.out.println("\n依姓名升序：");
        list.forEach(System.out::println);

        list.sort(StudentComparators.BY_BIRTHDAY.reversed());
        System.out.println("\n依出生日期降序：");
        list.forEach(System.out::println);

        // ③ 多鍵排序
        list.sort(StudentComparators.BY_SCORE_THEN_NAME);
        System.out.println("\n多鍵（成績↓ → 姓名↑）：");
        list.forEach(System.out::println);

        // ④ TreeSet 自動維持依學號排序
        TreeSet<Student> byId = new TreeSet<>(StudentComparators.BY_ID);
        byId.addAll(list);
        System.out.println("\nTreeSet 自動維持依學號排序：");
        byId.forEach(System.out::println);

        // ⑤ findMax：成績最高的學生
        Student top = StudentComparators.findMax(list, Comparator.comparingInt(Student::getScore));
        System.out.println("\n最高分：" + top);
    }
}
