package phase01basic.oop.lesson08;

public class Cash implements Payable {
    
    @Override public boolean pay(double amount) {
        System.out.printf("以現金支付 NT$%.0f%n", amount);
        return true;
    }

    @Override public String getMethodName() { return "現金"; }
}
