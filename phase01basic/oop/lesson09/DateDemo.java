package phase01basic.oop.lesson09;

import java.time.LocalDate;

public class DateDemo {
    public static void main(String[] args) {
        // 計算 2024 年的天數
        LocalDate start = DateCalculator.parse("2024/01/01");
        LocalDate end   = DateCalculator.parse("2024/12/31");

        System.out.println("開始日期：" + DateCalculator.format(start));
        System.out.println("結束日期：" + DateCalculator.format(end));
        System.out.printf("相差天數：%d 天%n",
            DateCalculator.daysBetween(start, end));

        System.out.println();

        // 生日相關計算
        LocalDate birthday = LocalDate.of(1990, 6, 15);
        System.out.println("生日：" + DateCalculator.format(birthday));
        System.out.println("年齡：" + DateCalculator.age(birthday) + " 歲");
        System.out.println("下次生日：" + DateCalculator.nextBirthday(birthday));
    }
}
