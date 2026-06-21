package phase01basic.oop.lesson08;

public interface OrderAction {
    void pay();
    void ship();
    void deliver();
    void cancel();
    OrderStatus getStatus();
}
