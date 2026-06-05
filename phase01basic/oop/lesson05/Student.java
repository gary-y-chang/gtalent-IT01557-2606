public class Student {
    String name;  int id;  double score;
    static int totalCount = 0; // 進階：記錄總人數

    public Student(String name, int id, double score) {
        this.name = name;  this.id = id;  this.score = score;
        totalCount++;
    }

    public void showInfo() {
        System.out.println("姓名:" + name + " 學號:" + id + " 成績:" + score);
    }

    public boolean isPass() { return score >= 60; }

    // 測試
    public static void main(String[] args) {
        Student s1 = new Student("小明", 101, 85.0);
        s1.showInfo();        // 姓名:小明 學號:101 成績:85.0
        var pass = s1.isPass();          // true
        int count = Student.totalCount;  // 1
    }
}
