import java.util.Arrays;

public class ArrayUtils {

    static int sum(int[] a) {
        int t = 0;
        for (int n : a) t += n;
        return t;
    }

    static void reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];  a[j] = tmp;
        }
    }

    static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5};
        reverse(n); 
        print(n);  // [5, 4, 3, 2, 1]
        // ✔ 原陣列已改變！（傳「參考值」的副本）
    }
}
