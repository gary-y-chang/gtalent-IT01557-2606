package phase01basic.oop.lesson07;

public class Animal {
    String name = "動物";

    void sound() { 
        System.out.println("~~~~~");
    }

    void info() {
        System.out.println("我是 " + name);
    }

    @Override
    public String toString() {
        return "我是 " + name;
    }
}
