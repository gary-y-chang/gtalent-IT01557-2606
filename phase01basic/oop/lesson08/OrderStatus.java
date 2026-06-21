package phase01basic.oop.lesson08;

import java.util.*;

public enum OrderStatus {
    CREATED,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    private Set<OrderStatus> nextStates;

    // 在 static 區塊定義流轉表（避免 enum 初始化順序問題）
    static {
        CREATED.nextStates   = Set.of(PAID, CANCELLED);
        PAID.nextStates      = Set.of(SHIPPED, CANCELLED);
        SHIPPED.nextStates   = Set.of(DELIVERED);
        DELIVERED.nextStates = Set.of();  // 終態
        CANCELLED.nextStates = Set.of();  // 終態
    }

    public boolean canTransitionTo(OrderStatus target) {
        return nextStates.contains(target);
    }

    public boolean isFinal() { return nextStates.isEmpty(); }
}

