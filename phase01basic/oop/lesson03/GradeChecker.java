package phase01basic.oop.lesson03;

import java.util.Scanner;

public class GradeChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入分數成績：");
        
        int score =sc.nextInt();
        // int score = Integer.parseInt(sc.nextLine());

        // if-else 版
        // String grade;

        // if (score >= 90)
        //     grade = "A";
        // else if (score >= 80)
        //     grade = "B";
        // else if (score >= 70)
        //     grade = "C";
        // else if (score >= 60)
        //     grade = "D";
        // else
        //     grade = "F";
        // System.out.println("等級: " + grade);

        // Switch Expression 改寫
        String grade2 = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
        System.out.println("等級: " + grade2);

        sc.close();
    }
}
