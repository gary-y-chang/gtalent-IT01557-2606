package phase01basic.oop.lesson08;

public class OrderDemo {
    public static void main(String[] args) {
        // 正常流程
        OrderAction o1 = new Order("A-001");
        o1.pay();      // CREATED -> PAID
        o1.ship();     // PAID -> SHIPPED
        o1.deliver();  // SHIPPED -> DELIVERED

        // 非法操作：在已送達的訂單上取消
        o1.cancel();   // 拒絕

        System.out.println();

        // 中途取消
        OrderAction o2 = new Order("A-002");
        o2.pay();      // CREATED -> PAID
        o2.cancel();   // PAID -> CANCELLED
    }
}
