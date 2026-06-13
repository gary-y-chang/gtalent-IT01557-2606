package phase01basic.oop.lesson02;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入身高（cm）：");
        double heightCm = sc.nextDouble();

        System.out.print("請輸入體重（kg）：");
        double weight = sc.nextDouble();
       
        double heightM = heightCm / 100.0; // 換算公尺

        double bmi = weight / (heightM * heightM);

        System.out.println("您的 BMI 值為: " + bmi);

        System.out.printf("您的 BMI 值為：%.2f%n", bmi);
        sc.close();

    }
}
