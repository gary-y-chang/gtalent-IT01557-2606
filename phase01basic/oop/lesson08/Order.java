package phase01basic.oop.lesson08;

public class Order implements OrderAction {
    private final String id;
    private OrderStatus status;

    public Order(String id) {
        this.id = id;
        this.status = OrderStatus.CREATED;
    }

    // 共通的轉換守門員
    private void moveTo(OrderStatus target) {
        if (!status.canTransitionTo(target)) {
            System.out.printf("[%s] 拒絕：%s -> %s%n", id, status, target);
            return;
        }
        System.out.printf("[%s] %s -> %s%n", id, status, target);
        this.status = target;
    }

    @Override public void pay()     { moveTo(OrderStatus.PAID); }
    @Override public void ship()    { moveTo(OrderStatus.SHIPPED); }
    @Override public void deliver() { moveTo(OrderStatus.DELIVERED); }
    @Override public void cancel()  { moveTo(OrderStatus.CANCELLED); }

    @Override
    public OrderStatus getStatus() { return status; }
}
