package phase01basic.oop.lesson08;

public class PaymentDemo {
    public static void main(String[] args) {
        // 不同支付方式裝進同一個陣列
        Payable[] methods = {
            new CreditCard("4321567890123456", "小明"),
            new LinePay("line_user_001"),
            new Cash()
        };

        double amount = 2580;

        for (Payable m : methods) {
            System.out.println("--- 嘗試以 " + m.getMethodName() + " 付款 ---");
            boolean ok = m.pay(amount);      // 多型！
            if (ok) m.printReceipt(amount);  // 多型！
        }
    }
}
