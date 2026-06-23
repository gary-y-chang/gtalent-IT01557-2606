package phase01basic.oop.lesson06;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record TransactionDto(String id, BigDecimal amount, LocalDateTime timestamp) {
    
    // 預先編譯格式化工具，提升效能
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 靜態工廠方法：將前端傳來的 HTTP 請求字串，轉換為強型別的 Record 物件
     */
    public static TransactionDto fromRequest(String id, String rawAmount, String rawTextTime) {
        BigDecimal parsedAmount = new BigDecimal(rawAmount);
        LocalDateTime parsedTime = LocalDateTime.parse(rawTextTime, FORMATTER);
        
        // 呼叫 Canonical Constructor
        return new TransactionDto(id, parsedAmount, parsedTime);
    }
}

