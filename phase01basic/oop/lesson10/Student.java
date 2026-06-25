package phase01basic.oop.lesson10;

public class Student implements Comparable<Student> {
    private final String id, name;
    private final int    score;

    public Student(String id, String name, int score) {
        this.id = id; this.name = name; this.score = score;
    }

    public String getId()    { return id;    }
    public String getName()  { return name;  }
    public int    getScore() { return score; }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score); // 成績降序
    }

    @Override
    public String toString() {
        return String.format("%s %s(%d)", id, name, score);
    }
}
