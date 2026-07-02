package phase01basic.oop.lesson10;

public class Dog extends Animal {

    private String name;

    public Dog(){
        super(4);
    }

    public Dog(String n){
        super(4);
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public String toString() {
        return "Dog(" + this.name + ")";
    }
}
