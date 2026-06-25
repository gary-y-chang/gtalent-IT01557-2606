package phase01basic.oop.lesson11;

import java.util.*;

public class TodoList {
    private final List<String> tasks = new ArrayList<>();

    public void add(String task) {
        if (task == null || task.isBlank()) {
            System.out.println("任務名稱不可為空");
            return;
        }
        tasks.add(task);
    }

    public void remove(String task) {
        if (!tasks.remove(task))
            System.out.println("找不到：" + task);
    }

    public void complete(String task) {
        int i = tasks.indexOf(task);
        if (i >= 0) tasks.set(i, "✓ " + task);
    }

    public void search(String kw) {
        List<String> found = new ArrayList<>();
        for (String t : tasks)
            if (t.contains(kw)) found.add(t);
        if (found.isEmpty())
            System.out.println("無符合項目");
        else found.forEach(System.out::println);
    }

    public void print() {
        System.out.println("=== 待辦清單 ===\n");
        for (int i = 0; i < tasks.size(); i++)
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        System.out.println();
    }

    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("讀 Java 集合框架");
        list.add("寫課後練習");
        list.add("複習 ArrayList");
        list.print();
        list.complete("讀 Java 集合框架");
        list.search("ArrayList");
    }
}
