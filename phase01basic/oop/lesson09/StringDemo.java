package phase01basic.oop.lesson09;

public class StringDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Windows").append(":").append("Java").append(" 2026");

        String result = sb.toString();
        System.out.println(result); // Output Windows:Java 2026

        sb.insert(8, " Linux ");
        System.out.println(sb.toString()); // Output Windows: Linux Java 2026

        sb.delete(0, 9);
        System.out.println(sb.toString()); // Output Linux Java 2026

        sb.replace(11, sb.length(), "2016");
        System.out.println(sb.toString()); // Output Linux Java 2016

        sb.reverse();
        System.out.println(sb.toString()); // Output 6102 avaJ xuniL

        // 判斷字串是否為空
        if (sb.toString().isEmpty()) {
            System.out.println("空白字串");
        }

        // 判斷字串是否包含某字串
        if (sb.toString().contains("6102")) {
            System.out.println("包含 6102 字串");
        }


        String name = "Alex";
        int version = 21;
        double score = 98.456;

        // %s = String, %d = Integer, %f = Floating-point
        String msg = String.format("User %s runs Java %d with a score of %.2f", name, version, score);
        System.out.println(msg);
        // Output: User Alex runs Java 21 with a score of 98.46 (Rounded to 2 decimal places)
    }
}
