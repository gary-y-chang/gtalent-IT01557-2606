package phase01basic.oop.lesson10;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    private final String id, name;
    private final int score;
    private final LocalDate birthday;

    public Student(String id, String name, int score, LocalDate bd) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthday = bd;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score); // 成績降序
    }

    // @Override
    // public int compareTo(Student o) {
    //     return this.birthday.compareTo(o.birthday);
    // }

    @Override
    public String toString() {
        return String.format("%s %s(%d) %s", id, name, score, birthday.toString());
    }
}
