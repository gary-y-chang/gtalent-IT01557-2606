package phase01basic.oop.lesson08;

public abstract class Animal {

    protected String name;

    // 抽象類別仍可有建構子
    Animal(String n) {
        this.name = n;
    }

    // 抽象方法：沒有方法主體，分號結尾
    public abstract void sound();

    // 一般方法：可以有實作
    public void sleep() {
        System.out.println(name + " 在睡覺");
    }
}
