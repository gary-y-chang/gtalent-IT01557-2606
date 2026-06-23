package phase01basic.oop.lesson06;

public record RecordOrder(String id, double amount) {
    // 應用：空物件模式（Null Object Pattern），提供一個安全的預設代表
    public static final RecordOrder EMPTY_ORDER = new RecordOrder("NONE", 0.0);
}

// 使用時機：
// RecordOrder myOrder = orderRepository.findById(id).orElse(RecordOrder.EMPTY_ORDER);

