package phase01basic.oop.lesson08;

public class LinePay implements Payable {
   
    private final String account;
   
    public LinePay(String account) { 
        this.account = account; }

    @Override public boolean pay(double amount) {
        System.out.printf("LINE Pay 帳號 %s 扣款 NT$%.0f%n", account, amount);
        return true;
    }
    @Override public String getMethodName() { return "LINE Pay"; }
    
}
