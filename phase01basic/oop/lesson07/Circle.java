package phase01basic.oop.lesson07;

public class Circle extends Shape{
     private double radius;
    Circle(double r) {
        super("Circle"); this.radius = r;
    }
    @Override public double area() {
        return Math.PI * radius * radius;
    }
    public double getRadius() { return radius; }
}
