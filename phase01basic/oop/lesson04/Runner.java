package phase01basic.oop.lesson04;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] numbers = {4, 8, 7, 2, 6, 1, 3, 5, 9};

        // BubbleSort.doSort(numbers);
        SelectionSort.doSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
