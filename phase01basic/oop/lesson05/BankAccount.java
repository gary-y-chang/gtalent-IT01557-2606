public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;  this.balance = balance;
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= balance) balance -= amt;
        else System.out.println("餘額不足");
    }

    public double getBalance() { return balance; }

    // 測試
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("小明", 1000);
        acc.deposit(500);   // 存入 500，餘額 1500
        acc.withdraw(200);  // 提款 200，餘額 1300
        acc.getBalance();   // 1300.0
    }
}
