import java.util.Arrays;

public class ScoreManager {
    public static void main(String[] args) {
        int[] sc = {85, 92, 78, 65, 90, 88};

        // ① 加總、平均
        int sum = 0;
        for (int s : sc) sum += s;
        System.out.printf("平均: %.1f%n", (double) sum / sc.length);

        // ② 最高分與位置
        int max = sc[0], pos = 0;
        for (int i = 1; i < sc.length; i++)
            if (sc[i] > max) { max = sc[i]; pos = i; }
        System.out.printf("最高: %d (index %d)%n", max, pos);

        // ③ 高→低排序輸出
        Arrays.sort(sc);
        for (int i = sc.length - 1; i >= 0; i--)
            System.out.print(sc[i] + " ");
        // 輸出: 92 90 88 85 78 65
    }
}
