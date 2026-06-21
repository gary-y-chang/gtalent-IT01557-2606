package phase01basic.oop.lesson07;

class Shape {
    protected String name;
    Shape(String name) { this.name = name; }
    public double area() { return 0; }

    @Override public String toString() {
        return name + " area=" + area();
    }
}


