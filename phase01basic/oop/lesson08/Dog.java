package phase01basic.oop.lesson08;

public class Dog extends Animal {

    public Dog(String n) {
        super(n);
    }

    @Override
    public void sound() {
        System.out.println("汪汪");
    }

    public static void main(String[] args) {

        Animal d1 = new Dog("小黑");
        Dog d2 = new Dog("大寶");

        // Animal dd = new Animal("抽象動物");

        System.out.println("----------> " + d1.name);
        d1.sound();
        d1.sleep();

        System.out.println("----------> " + d2.name);
        d2.sound();
        d2.sleep();


    }
}
