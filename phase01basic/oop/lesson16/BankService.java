package phase01basic.oop.lesson16;

import java.sql.*;

public class BankService {
    final Connection conn;

    BankService(Connection conn) {
        this.conn = conn;
    }

    void transfer(int from, int to, double amt) throws SQLException {
        conn.setAutoCommit(false);
        try {
            if (balanceOf(from) < amt)
                throw new IllegalStateException("餘額不足");
            update(from, -amt); // 扣款
            update(to,  +amt);  // 入款
            conn.commit();      // 全部成功
            System.out.println("轉帳成功，已 commit");
        } catch (Exception e) {
            conn.rollback();    // 任一步失敗 → 還原
            System.out.println("轉帳失敗：" + e.getMessage() + "，已 rollback，資料不變");
            throw e instanceof SQLException se ? se
                : new SQLException(e);
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private double balanceOf(int accountId) throws SQLException {
        String sql = "SELECT balance FROM account WHERE id=?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            try (var rs = ps.executeQuery()) {
                return rs.next() ? rs.getDouble("balance") : 0;
            }
        }
    }

    private void update(int accountId, double delta) throws SQLException {
        String sql = "UPDATE account SET balance = balance + ? WHERE id=?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, delta);
            ps.setInt(2, accountId);
            ps.executeUpdate();
        }
    }
}
