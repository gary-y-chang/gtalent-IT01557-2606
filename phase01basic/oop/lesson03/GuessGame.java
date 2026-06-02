package phase01basic.oop.lesson03;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int answer = rand.nextInt(100) + 1;
        int count = 0;
        int guess;
        do {
            System.out.print("請猜一個數字(1-100): ");
            guess = sc.nextInt();
            count++;
            if (guess > answer)
                System.out.println("太大");
            else if (guess < answer)
                System.out.println("太小");
        } while (guess != answer);
        System.out.printf("答對了！共猜 %d 次%n", count);
        sc.close();
    }

}
