package phase01basic.oop.lesson10;

import java.util.*;

public class StudentComparators {

    // 依姓名升序
    public static final Comparator<Student>
        BY_NAME = Comparator.comparing(Student::getName);

    // 依學號升序
    public static final Comparator<Student>
        BY_ID = Comparator.comparing(Student::getId);

    // 多鍵：成績降序 → 同分依姓名升序
    public static final Comparator<Student>
        BY_SCORE_THEN_NAME =
            Comparator.comparingInt(Student::getScore)
                      .reversed()
                      .thenComparing(Student::getName);

    // 泛型工具：找出最大值
    public static <T extends Comparable<T>> T
    findMax(List<T> list) {
        return Collections.max(list);
    }
}
