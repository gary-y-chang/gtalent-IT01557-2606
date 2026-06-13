public class BubbleSort {

    public static void doSort(int[] arr) {
        int n = arr.length;
        // 外層迴圈：控制總共要做幾輪
        for (int i = 0; i < n - 1; i++) {
            // 內層迴圈：兩兩比較。因為每做完一輪，後面就有一個數字固定了，所以可以少比較 i 個數字
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左邊大於右邊，就進行交換 (Swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
