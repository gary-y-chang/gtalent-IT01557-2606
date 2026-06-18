package phase01basic.oop.lesson06;

public class Car {
    private String brand;
    private int    year;
    private double price;

    public Car(String brand, int year, double price) {
        this.brand = brand;
        setYear(year);  setPrice(price);
    }

    public String getBrand() { return brand; }
    public void   setBrand(String b) { this.brand = b; }

    public int  getYear() { return year; }
    public void setYear(int y) {
        if (y >= 1886) this.year = y;
        else System.out.println("❌ 年份無效");
    }

    public double getPrice() { return price; }
    public void   setPrice(double p) {
        if (p >= 0) this.price = p;
        else System.out.println("❌ 價格不能為負");
    }

    @Override
    public String toString() {
        return "Car{brand=" + brand
            + ", year=" + year
            + ", price=" + price + "}";
    }
}
