package phase01basic.oop.lesson06;

public class Employee {
    private String empId;
    private String name;
    private String department;
    private double salary;

    // 無參數建構子 → 委派給 2 參數
    public Employee() {
        this("N/A", "未知");
    }

    // 2 參數建構子 → 委派給 4 參數
    public Employee(String empId, String name) {
        this(empId, name, "未分配", 0);
    }

   
    public Employee(String empId, double salary) {
        this(empId, "未知", "未分配", salary);
    }

    // 完整 4 參數建構子（主邏輯）
    public Employee(String empId, String name, String dept, double salary) {
        this.empId = empId;  
        this.name = name;
        this.department = dept;  
        setSalary(salary);
    }

    public String  getEmpId(){ 
        return empId; 
    }
    
    public String  getName(){ 
        return name; 
    }
    public String  getDepartment() { 
        return department; 
    }
    public double  getSalary(){ 
        return salary; 
    }

    public void    setName(String n) { this.name = n; }
    public void    setDepartment(String d) { this.department = d; }
    public void    setSalary(double s) {
        if (s >= 0) this.salary = s;
    }

    @Override
    public String toString() {
        return "Employee{id=" + empId + ", name=" + name
            + ", dept=" + department + ", salary=" + salary + "}";
    }
}
