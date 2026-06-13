import java.util.Arrays;

public class SelectionSort {

    public static void doSort(int[] arr) {
        int count = 0; // 用來記錄經過多少回合
        int n = arr.length;
        // 外層迴圈：控制當前要把「最小的值」放到哪一個位置
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // 先假設目前第一個未排序的位置就是最小的

            // 內層迴圈：往後掃描所有未排序的數字，尋找真正最小的數字在哪裡
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; // 記下更小數字的索引位置 ()
                }
            }
            // 找到這輪最小的數字後，和最前面的未排序數字交換
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            System.out.printf("第%d輪比較, --> %s%n", ++count, Arrays.toString(arr));
        }
    }
}
