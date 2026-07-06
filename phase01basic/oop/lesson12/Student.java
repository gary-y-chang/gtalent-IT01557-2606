package phase01basic.oop.lesson12;

public class Student {
    private final String name;
    private final int score;
    private final int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s(%d) %d", name, score, age);
    }   
}
