package phase01basic.oop.lesson01;


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[] a = {3, 1, 4, 1, 5, 9};

        // int[] b = Arrays.copyOf(a, 10);

        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        int[] b = a; 

        System.out.println(a == b);

    }
}