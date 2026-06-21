package phase01basic.oop.lesson07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Product a = new Product("P01", "滑鼠", 590);
        Product b = new Product("P01", "滑鼠(特價)", 490);

        System.out.println(a);           // Product{id=P01, name=滑鼠, price=590}
        System.out.println(a.equals(b)); // true

        Set<Product> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size()); // 1
    }
}
