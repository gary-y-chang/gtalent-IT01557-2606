package phase01basic.oop.lesson08;

public interface Payable {
    boolean pay(double amount);

    String getMethodName();

    // 預設印收據
    default void printReceipt(double amount) {
        System.out.printf("[%s] 已收款 NT$%.0f%n",
            getMethodName(), amount);
    }
}

