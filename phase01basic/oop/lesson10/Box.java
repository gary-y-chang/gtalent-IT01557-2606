package phase01basic.oop.lesson10;

public class Box<T> {

    private T value;

    public static <T> void printBox(T box){
        System.out.println(box);
    }

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T v) {
        this.value = v;
    }
}
