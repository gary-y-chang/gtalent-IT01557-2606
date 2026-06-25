package phase01basic.oop.lesson09;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateCalculator {
    private static final DateTimeFormatter FMT =
        DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static long daysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

    public static long daysFromToday(LocalDate d) {
        return ChronoUnit.DAYS.between(LocalDate.now(), d);
    }

    public static String format(LocalDate d) {
        return d.format(FMT);
    }

    public static LocalDate parse(String s) {
        return LocalDate.parse(s, FMT);
    }

    public static int age(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public static String nextBirthday(LocalDate bday) {
        LocalDate next = bday.withYear(LocalDate.now().getYear());
        if (!next.isAfter(LocalDate.now()))
            next = next.plusYears(1);
        long days = ChronoUnit.DAYS.between(LocalDate.now(), next);
        return format(next) + "（還有 " + days + " 天）";
    }
}
