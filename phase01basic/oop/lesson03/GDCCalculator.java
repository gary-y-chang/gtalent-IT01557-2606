package phase01basic.oop.lesson03;

import java.util.Scanner;

public class GDCCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入第一個正整數：");
        int a = sc.nextInt();
        System.out.print("請輸入第二個正整數：");
        int b = sc.nextInt();
        int x = a, y = b; // 備份原值
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        System.out.printf("%d 與 %d 的最大公因數：%d%n", a, b, x);
        sc.close();     
    }
}
