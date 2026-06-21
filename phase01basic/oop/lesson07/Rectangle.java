package phase01basic.oop.lesson07;

public class Rectangle extends Shape{
    private double w, h;
    
    Rectangle(double w, double h) {
        super("Rectangle");
        this.w = w; this.h = h;
    }
    
    @Override public double area() { return w * h; }
}
