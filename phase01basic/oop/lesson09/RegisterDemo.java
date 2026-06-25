package phase01basic.oop.lesson09;

public class RegisterDemo {

    static void register(String u, String p, String e) {
        System.out.printf("--- 註冊 %s ---%n", u);
        try {
            AccountValidator.validateUsername(u);
            AccountValidator.validatePassword(p);
            AccountValidator.validateEmail(e);
            System.out.println("✅ 帳號 [" + u + "] 註冊成功！");
        } catch (ValidationException ex) {
            System.out.println("❌ " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        register("alice123", "Password1", "alice@example.com");
        register("ab",       "Password1", "alice@example.com");
        register("alice123", "pass",      "alice@example.com");
        register("alice123", "password1", "alice@example.com");
        register("alice123", "Password1", "invalid-email");
    }
}
