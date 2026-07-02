package phase01basic.oop.lesson10;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS 法則示範：Producer Extends, Consumer Super
 *
 * copy(dest, src)： dest 是「消費者 Consumer」→ 只寫入 → 用 ? super T src 是「生產者 Producer」→ 只讀取 → 用 ? extends T
 *
 * 這正是 JDK java.util.Collections.copy 的寫法。
 */
public class PecsCopyDemo {

    // ── 型別階層：Animal ← Dog ← Puppy ──────────────────────────
   
    /**
     * 泛型方法：把 src 的每個元素依序複製到 dest。
     *
     * List<? extends T> src → 生產者：從裡面「讀」出 T（含 T 的子型別） List<? super T> dest → 消費者：把 T（含 T 的子型別）「寫」進去
     */
    static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            T item = src.get(i); // ✅ src 讀取：取出的元素保證是 T
            dest.add(item); // ✅ dest 寫入：T 一定塞得進 ? super T
        }
    }

    public static void main(String[] args) {
        // src：一群 Dog（生產者，提供資料）
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Rex"));
        dogs.add(new Puppy("Milo")); // Puppy 也是 Dog，可放入

        // dest：一個 Animal 的容器（消費者，接收資料）
        List<Animal> animals = new ArrayList<>();

        // T 被推斷為 Dog：
        // dest = List<Animal> 符合 List<? super Dog> ✅
        // src = List<Dog> 符合 List<? extends Dog> ✅
        copy(animals, dogs);
        System.out.println("複製到 Animal 容器：" + animals);
        // [Dog(Rex), Puppy(Milo)]

        // 也能複製到更寬鬆的 Object 容器（? super Dog 涵蓋 Object）
        List<Object> box = new ArrayList<>();
        copy(box, dogs);
        System.out.println("複製到 Object 容器：" + box);

        // ── 若違反 PECS，編譯就會失敗（示範，故意註解掉）──────────
        // src.add(new Dog("X")); // ❌ ? extends T 不能寫入
        // T out = dest.get(0); // ❌ ? super T 讀出只能當 Object

        System.out.println("\nPECS 口訣：Producer→Extends（讀），Consumer→Super（寫）");
    }
}
