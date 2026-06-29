package phase01basic.oop.lesson12;

@FunctionalInterface
public interface Greeting {

    // 唯一的抽象方法
    String greet(String name); 
    
    // default 方法：不影響函數式介面資格
    default Greeting withExclamation() {
        return name -> this.greet(name) + " !!!";
    }

    // static 方法：同上，不影響
    static Greeting formal() {
        return name -> "Dear " + name;
    }
}
