package phase01basic.oop.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NumberRange implements Iterable<Integer> {
    private final int start, end;

    public NumberRange(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int cur = start;

            public boolean hasNext() {
                return cur <= end;
            }

            public Integer next() {
                return cur++;
            }
        };
    }

    public static void main(String[] args) {
        NumberRange range = new NumberRange(1, 5);
        for (int num : range) {
            System.out.println(num);
        }

        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Carol", "Dave"));

        // for (String name : names) {
        //     System.out.println(name);
        //     if (name.equals("Bob")) {
        //         names.remove(name); // This will throw ConcurrentModificationException
        //     }
        // }

        Iterator<String> itet = names.iterator();   
        while (itet.hasNext()) {
            String name = itet.next();
            System.out.println(name);
            if (name.equals("Bob")) {
                itet.remove(); // This is the correct way to remove an element while iterating
            }
        }
        System.out.println("After removal: " + names);

        names.removeIf(name -> name.equals("Alice")); // This is another correct way to remove elements while iterating
        System.out.println("After removal with removeIf: " + names);
    }
}
