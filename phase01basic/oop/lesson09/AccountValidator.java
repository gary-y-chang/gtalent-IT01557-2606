package phase01basic.oop.lesson09;

public class AccountValidator {

    public static void validateUsername(String u)
            throws ValidationException {
        if (u == null || u.length() < 4 || u.length() > 20)
            throw new ValidationException("username", "長度需在 4-20 字元");
        if (!u.matches("[a-zA-Z0-9]+"))
            throw new ValidationException("username", "只能包含英文字母與數字");
    }

    public static void validatePassword(String p)
            throws ValidationException {
        if (p == null || p.length() < 8)
            throw new ValidationException("password", "長度不得少於 8 字元");
        if (!p.matches(".*[A-Z].*"))
            throw new ValidationException("password", "需含至少一個大寫字母");
        if (!p.matches(".*[a-z].*"))
            throw new ValidationException("password", "需含至少一個小寫字母");
        if (!p.matches(".*\\d.*"))
            throw new ValidationException("password", "需含至少一個數字");
    }

    public static void validateEmail(String e)
            throws ValidationException {
        if (e == null ||
            !e.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$"))
            throw new ValidationException("email", "格式不正確");
    }
}
