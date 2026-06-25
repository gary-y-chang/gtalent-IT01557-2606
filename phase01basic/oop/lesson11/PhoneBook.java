package phase01basic.oop.lesson11;

import java.util.*;

public class PhoneBook {
    private final Map<String, String> book = new HashMap<>();

    public void add(String name, String phone) {
        if (book.containsKey(name))
            System.out.println("已覆蓋 " + name + " 的電話");
        book.put(name, phone);
    }

    public void lookup(String name) {
        String p = book.get(name);
        if (p != null)
            System.out.println(name + " → " + p);
        else System.out.println("查無此人：" + name);
    }

    public void delete(String name) {
        if (book.remove(name) == null)
            System.out.println("找不到：" + name);
    }

    public void searchByPhone(String phone) {
        book.entrySet().stream()
            .filter(e -> e.getValue().equals(phone))
            .findFirst()
            .ifPresentOrElse(
                e -> System.out.println("電話 " + phone + " 是 " + e.getKey()),
                () -> System.out.println("查無此電話：" + phone));
    }

    public void listAll() {
        System.out.println("=== 電話簿（依姓名排序）===");
        new TreeMap<>(book).forEach((n, p) ->
            System.out.printf("%s：%s%n", n, p));
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Alice", "0912-345-678");
        pb.add("Bob",   "0923-456-789");
        pb.add("Carol", "0934-567-890");
        pb.lookup("Alice");
        pb.lookup("Dave");           // 查無此人
        pb.searchByPhone("0923-456-789");
        pb.delete("Bob");
        pb.listAll();
    }
}
