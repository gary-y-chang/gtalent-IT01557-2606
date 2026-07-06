package phase01basic.oop.lesson12;

import java.util.*;
import java.util.function.*;

public class FunctionPipeline {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Alice",   75, 20),
            new Student("Bob",     88, 22),
            new Student("Charlie", 92, 19));

        // 定義各個轉換函數
        // Function<Student, String> toName  = Student::getName;
        Function<Student, String> toName  = s -> s.getName();
        
        // Function<String,  String> toUpper = String::toUpperCase;
        Function<String,  String> toUpper = s -> s.toUpperCase();

        Function<String,  String> bracket = s -> "[" + s + "]";

        // 串接成 pipeline
        Function<Student, String> pipeline = toName.andThen(toUpper).andThen(bracket); 

        // System.out.println("=== 格式化姓名 ===");
        // students.forEach(s -> System.out.println(pipeline.apply(s)));

        // CSV 轉換 comma separated values   abc, 456, 789
        Function<Student, String> toCsv = s -> s.getName() + "," + s.getScore() + "," + s.getAge();
        
        System.out.println("=== CSV 匯出 ===\nname,score,age");
        students.forEach(s -> System.out.println(toCsv.apply(s)));
    }
}
