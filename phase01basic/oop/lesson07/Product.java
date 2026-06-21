package phase01basic.oop.lesson07;

import java.util.Objects;

class Product {
    private String id, name;
    
    private int price;

    Product(String id, String name, int price) {
        this.id    = id;
        this.name  = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id
            + ", name=" + name
            + ", price=" + price + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product p)) return false;
        return Objects.equals(id, p.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
