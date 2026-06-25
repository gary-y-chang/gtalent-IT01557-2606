package phase01basic.oop.lesson07;

public class Cat extends Animal {

    String name = "小花"; // 同名

    @Override
    void sound() {
        System.out.println("喵～");
    }

    @Override
    public String toString() {
        return "我是 " + name;
    }
}
