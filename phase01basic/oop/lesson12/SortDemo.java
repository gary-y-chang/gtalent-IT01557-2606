package phase01basic.oop.lesson12;

import java.util.*;

class Student {
    private String name; private int score, age;
    public Student(String n, int s, int a) { name = n; score = s; age = a; }
    public String getName()  { return name; }
    public int    getScore() { return score; }
    public int    getAge()   { return age; }
    public String toString() { return name + "(" + score + ")"; }
}

public class SortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Alice",   75, 20),
            new Student("Bob",     88, 21),
            new Student("Charlie", 92, 19),
            new Student("Dave",    61, 22)));

        // ② 依成績降序
        list.sort(Comparator.comparingInt(Student::getScore).reversed());
        System.out.println("依成績降序：" + list);

        // ③ 依姓名升序（方法參考）
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("依姓名升序：" + list);

        // ④ 多重排序：成績↓，姓名↑
        list.sort(Comparator.comparingInt(Student::getScore)
            .reversed().thenComparing(Student::getName));
        System.out.println("多重排序：" + list);
    }
}
