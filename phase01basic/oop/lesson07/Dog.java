package phase01basic.oop.lesson07;

import java.util.Objects;

public class Dog extends Animal {
    String name = "小黑"; // 同名

    @Override
    void sound() {
        System.out.println("汪～");
    }

    @Override
    void info() {
        System.out.println("父 = " + super.name);
        System.out.println("子 = " + name);
        super.info(); // 呼叫父類別版本
    }

    @Override
    public String toString() {
        return "我是 " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog d)) return false;
        return Objects.equals(name, d.name);
    }

    @Override
    public int hashCode() {
         return Objects.hash(name);
    }

    public static void main(String[] args) {
        // Dog dog = new Dog();
        // System.out.println(dog.name);

        // dog.info();
        Animal d1 = new Dog();
        Animal d2 = new Dog();

        System.out.println("----------> "+ d1.equals(d2));

        // Animal[] zoo = {new Dog(), new Cat()};
        // for(Animal a: zoo){
        //    System.out.println(a);
        // }

    }
}
