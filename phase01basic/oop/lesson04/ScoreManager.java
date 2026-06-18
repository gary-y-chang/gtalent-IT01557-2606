package phase01basic.oop.lesson04;

import java.util.Arrays;
import java.util.Collections;

public class ScoreManager {
    public static void main(String[] args) {
        int[] sc = {85, 92, 78, 65, 90, 88};
       

        // 加總、平均
        int sum = 0;
        for (int s : sc){
            sum += s;
        }

        System.out.printf("平均: %.1f%n", (double) sum / sc.length);

        // 最高分與位置
        int max = sc[0], pos = 0;
        for (int i = 1; i < sc.length; i++){
            if (sc[i] > max) { 
                max = sc[i]; 
                pos = i; 
            }
        }
        System.out.printf("最高: %d (index %d)%n", max, pos);

        // 低->高排序
        Arrays.sort(sc); 
        System.out.print("排序後: ");
        for (int s : sc) System.out.print(s + " ");
        System.out.println();
       // 高→低排序輸出
        for (int i = sc.length - 1; i >= 0; i--)
            System.out.print(sc[i] + " ");
        // 輸出: 92 90 88 85 78 65

        Integer[] sc2 = {85, 92, 78, 65, 90, 88};
        Arrays.sort(sc2, Collections.reverseOrder()); // 直接高→低排序
        System.out.println("\n高→低排序: " + Arrays.toString(sc2)); 

    }
}
