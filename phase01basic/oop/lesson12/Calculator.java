package phase01basic.oop.lesson12;

@FunctionalInterface
public interface Calculator  {
    // 只能有一個抽象方法
    int compute(int a, int b); 
    
    // 如果寫第二個抽象方法，編譯器就會直接報錯！
    // void errorMethod(); 
}
