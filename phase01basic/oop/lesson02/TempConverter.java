package phase01basic.oop.lesson02;

import java.util.Scanner;

public class TempConverter {
    static final double FACTOR = 9.0 / 5.0; // 1.8
    static final int OFFSET = 32;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入攝氏溫度（°C）：");
        double celsius = sc.nextDouble();
       
        double fahrenheit = celsius * FACTOR + OFFSET;
       
        System.out.printf("華氏溫度：%.2f °F%n", fahrenheit);
        System.out.printf("驗算回攝氏：%.2f °C%n", (fahrenheit - OFFSET) * 5.0 / 9.0);
        sc.close();
    }
}
