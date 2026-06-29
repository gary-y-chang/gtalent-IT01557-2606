package phase01basic.oop.lesson09;

/**
 * Return in finally 在 finally 中使用 return 會強制覆蓋前面 try/catch 的所有行為（包含 throw）
 * 1. 覆蓋 try 的結果：當 try 正常執行並準備回傳成功資料時，finally 的 return 會將其蓋掉。
 * 2. 吞沒 catch 的例外：當 try 發生錯誤進入 catch，此時若 finally 有 return，程式會直接返回並中斷錯誤拋出。這會導致外層永遠無法捕捉到錯誤
 */

public class FinallyReturn {

    public static int getDiscountRate() throws Exception {
        try {
        
            // 這裡模擬商業邏輯正確，原本欲返回 40% 的折扣
            return 40;

            // 這裡模擬發生嚴重商業邏輯錯誤
            // throw new Exception("系統故障：無法獲取會員等級");
        } catch (Exception e) {
            // 預期將錯誤往外拋，讓上層 controller 處理並記錄日誌
            throw e; 
        } finally {
            // 反面教材：在 finally 中使用了 return ,
            // 這會強制覆蓋前面 try/catch 的所有行為（包含 throw）
            return 100; 
        }
    }

    public static void main(String[] args) {
        try {
            int rate = getDiscountRate();
            // ⚠️ 程式居然順利執行到這裡，並印出 100% 折扣！
            System.out.println("成功獲取折扣率: " + rate + "%");
        } catch (Exception e) {
            // 這裡永遠不會被執行，錯誤被無情地隱藏了
            System.out.println("捕獲到異常: " + e.getMessage());
        }
    }
}

