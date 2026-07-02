package phase01basic.oop.lesson10;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private static final Random RND = new Random();

    public static Set<Integer> generate(int count, int max) {
        Set<Integer> nums = new HashSet<>();
        while (nums.size() < count)
            nums.add(RND.nextInt(max) + 1); // 自動去重
        return new TreeSet<>(nums); // 排序後回傳
    }

    public static void main(String[] args) {
        System.out.println("=== 大樂透選號 ===");
        List<Set<Integer>> tickets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Set<Integer> t = generate(6, 49);
            tickets.add(t);
            System.out.printf("第 %d 注：%s%n", i, t);
        }

        // 對獎：retainAll 取交集，複製後操作不影響原始彩票
        System.out.println("\n=== 對獎結果 ===");
        Set<Integer> draw = generate(6, 49);
        System.out.println("開獎號碼：" + draw);
        for (int i = 0; i < tickets.size(); i++) {
            Set<Integer> cp = new HashSet<>(tickets.get(i)); // 複製
            cp.retainAll(draw); // 取交集
            System.out.printf("第 %d 注：對中 %d 顆%s%n", i + 1, cp.size(), cp.size() == 6 ? " 🎉" : "");
        }
    }
}
