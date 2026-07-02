package phase01basic.oop.lesson10;

import java.util.*;

public class StudentComparators {

    // 依姓名升序
    public static final Comparator<Student>
        BY_NAME = Comparator.comparing(Student::getName);

    // 依學號升序
    public static final Comparator<Student>
        BY_ID = Comparator.comparing(Student::getId);

    // 依出生日期升序 
    public static final Comparator<Student> BY_BIRTHDAY 
        =  Comparator.comparing(Student::getBirthday);  

    // public static final Comparator<Student> BY_BIRTHDAY 
    //     =  (s1, s2) -> s1.compareTo(s2);      

    // 多鍵：成績降序 → 同分依姓名升序
    public static final Comparator<Student>
        BY_SCORE_THEN_NAME =
            Comparator.comparingInt(Student::getScore)
                      .reversed()
                      .thenComparing(Student::getName);

    // 泛型工具：依指定 Comparator 找出最大值
    public static <T> T findMax(List<T> list, Comparator<? super T> cmp) {
        return Collections.max(list, cmp);
    }
}
