package phase01basic.oop.lesson05;

public class Student {
    
    private String name;  
    private int id;  
    private double score;
    
    static int totalCount = 0; // 進階：記錄總人數

    public Student(String n, int d, double s) {
        name = n;  
        id = d;  
        score = s;
        totalCount++;
    }

    public void showInfo() {
        System.out.println("姓名:" + name + " 學號:" + id + " 成績:" + score);
    }

    public boolean isPass() { return score >= 60; }

    // 測試
    public static void main(String[] args) {
        Student student = new Student("小明", 101, 85.0);
        Student student2 = new Student("小華", 102, 75.0);
        Student student3 = new Student("小李", 103, 95.0);

        student.showInfo();        // 姓名:小明 學號:101 成績:85.0
        student2.showInfo();       // 姓名:小華 學號:102 成績:75.0
        student3.showInfo();       // 姓名:小李 學號:103 成績:95.0

        // Student.totalCount = 100; // 錯誤！應該用 Student.totalCount, 因為 totalCount 是類別層級的變數，不是物件層級的
        boolean pass = student.isPass();          // true

        int count = Student.totalCount;  // 原本應是 3
        System.out.println("總人數: " + count); // 總人數: 3
    }
}
