package phase01basic.oop.lesson16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;

record Employee(int id, String name, double salary) {
}

class EmployeeDaoJdbc {
    final Connection conn;

    EmployeeDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    void insert(Employee e) throws SQLException {
        String sql = "INSERT INTO employee(name, salary) VALUES (?, ?)";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.name());
            ps.setDouble(2, e.salary());
            ps.executeUpdate();
        }
    }

    Employee findById(int id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id=?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                return rs.next() ? map(rs) : null;
            }
        }
    }

    List<Employee> findAll() throws SQLException {
        String sql = "SELECT * FROM employee";
        List<Employee> list = new ArrayList<>();
        try (var ps = conn.prepareStatement(sql);
                var rs = ps.executeQuery()) {
            while (rs.next())
                list.add(map(rs));
        }
        return list;
    }

    void update(Employee e) throws SQLException {
        String sql = "UPDATE employee SET name=?, salary=? WHERE id=?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.name());
            ps.setDouble(2, e.salary());
            ps.setInt(3, e.id());
            ps.executeUpdate();
        }
    }

    void delete(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // 輔助：將一列 ResultSet 轉成 Employee
    private Employee map(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("salary"));
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample_db";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            EmployeeDaoJdbc daoJdbc = new EmployeeDaoJdbc(conn);

            List<Employee> employees = daoJdbc.findAll();
            employees.forEach(emp -> System.out.println(emp.toString()));

            System.out.println("------------------------------------");

            Employee employee = daoJdbc.findById(2);
            System.err.println(employee);

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

    }
}
