package phase01basic.oop.lesson03;

public class FindMin2D {
    public static void main(String[] args) {
        int[][] arr = {{12, 6, 28, 9}, {23, 4, 74, 57}};
        int min = arr[0][0];
        int minX = 0, minY = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (arr[x][y] < min) {
                    min = arr[x][y];
                    minX = x;
                    minY = y;
                }
            }
        }
        System.out.printf(">> 最小值= %d，索引值= [%d][%d]%n", min, minX, minY);
    }

}
