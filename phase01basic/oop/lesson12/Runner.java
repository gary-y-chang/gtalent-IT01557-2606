package phase01basic.oop.lesson12;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Runner {
    public static void main(String[] args) {
        // Calculator c = new MyCalculator();
        Calculator cc = (a, b) -> a + b;
        System.out.println(cc.compute(3, 5));

        Greeting casual  = name -> "Hi, " + name;

        String msg1 = casual.greet("Keven");
        String msg2 = casual.withExclamation().greet("Jackey");
        String msg3 = Greeting.formal().greet("Larry");

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);
        
        BiFunction<Integer, Integer, Integer> mymax = (a, b) -> Math.max(a, b);
        BiFunction<Integer, Integer, Integer> mymaxref = Math::max;
        Integer m = mymaxref.apply(3, 1);
        System.out.println(m);
    }
}
