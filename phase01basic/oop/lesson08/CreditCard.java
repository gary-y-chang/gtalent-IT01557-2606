package phase01basic.oop.lesson08;

public class CreditCard implements Payable {
    private final String cardNo, holder;

    public CreditCard(String cardNo, String holder) {
        if (cardNo == null || cardNo.length() < 4)
            throw new IllegalArgumentException("卡號錯誤");
        this.cardNo = cardNo; this.holder = holder;
    }

    @Override public boolean pay(double amount) {
        if (amount > 100000) {
            System.out.println("金額超過信用額度"); return false;
        }
        System.out.printf("信用卡 %s 扣款 NT$%.0f%n", lastFour(), amount);
        return true;
    }

    @Override public String getMethodName() { return "信用卡"; }

    // 覆寫預設收據：附上卡號末四碼
    @Override public void printReceipt(double amount) {
        System.out.printf("[信用卡 ****%s] %s 已支付 NT$%.0f%n",
            lastFour(), holder, amount);
    }

    private String lastFour() {
        return cardNo.substring(cardNo.length() - 4);
    }
}
