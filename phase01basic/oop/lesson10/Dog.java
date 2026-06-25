package phase01basic.oop.lesson10;

public class Dog extends Animal {

    private String sound;

    public Dog(){
        super(4);
    }

    public Dog(String sound){
        super(4);
        this.sound = sound;
    }

    public String getSound(){
        return this.sound;
    }
}
