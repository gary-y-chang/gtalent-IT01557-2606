package phase01basic.oop.lesson12;

import java.util.*;
import java.util.function.Predicate;

public class PredicateFilter {

    // 通用 filter 方法
    static List<Student> filter(List<Student> list, Predicate<Student> p) {
        List<Student> result = new ArrayList<>();
        
        for (Student s : list)
            if (p.test(s))
                 result.add(s);
                
        return result;
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Alice",   75, 20),
            new Student("Bob",     88, 22),
            new Student("Charlie", 92, 19),
            new Student("Dave",    55, 21),
            new Student("Eve",     42, 20));

        // 定義 Predicate
        Predicate<Student> isPassed    = s -> s.getScore() >= 60;
        Predicate<Student> isShortName = s -> s.getName().length() <= 5;

        // 組合篩選
        System.out.println("及格：" + filter(students, isPassed));
        System.out.println("及格且短名：" + filter(students, isPassed.and(isShortName)));
        System.out.println("不及格：" + filter(students, isPassed.negate()));
    }
}
