package phase01basic.oop.lesson10;

public class Pair<K, V> {
    private final K first;
    private final V second;

    // private 建構子：強制透過工廠方法建立
    private Pair(K first, V second) {
        this.first  = first;
        this.second = second;
    }

    // 靜態工廠方法：須自己宣告 <K, V>
    public static <K, V> Pair<K, V> of(K k, V v) {
        return new Pair<>(k, v);
    }

    public K getFirst()  { return first;  }
    public V getSecond() { return second; }

    // swap()：回傳型別交換的新 Pair<V, K>
    public Pair<V, K> swap() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pair<String, Integer> p = Pair.of("Alice", 95);
        System.out.println(p);           // (Alice, 95)
        System.out.println(p.getFirst()); // Alice
        System.out.println(p.getSecond()); // 95
        System.out.println(p.swap());    // (95, Alice)

        var list = java.util.List.of(Pair.of("Alice", 95), Pair.of("Bob", 88));
        list.forEach(System.out::println);
    }
}
