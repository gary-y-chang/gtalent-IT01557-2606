package phase01basic.oop.lesson10;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // 測試 Team 類別
        // Team myTeam = new Team();
        // for (String player : myTeam) {
        //     System.out.println(player);
        // }

        // 測試 Utility 類別的泛型方法
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World", "!"};

        System.out.println("Integer Array:");
        Utility.printArray(intArray);

        System.out.println("String Array:");
        Utility.printArray(strArray);

        Utility utility = new Utility();
        System.out.println("First element of intArray: " + utility.getFirstElement(List.of(intArray)));
        System.out.println("First element of strArray: " + utility.getFirstElement(List.of(strArray)));
    }
}
