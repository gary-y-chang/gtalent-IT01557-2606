package phase01basic.oop.lesson10;

public class Animal {
    private int legs;

    public Animal(){
        this.legs = 4;
    }

    public Animal(int legs){
        this.legs = legs;
    }

    public int getLegs(){
        return this.legs;
    }
}
