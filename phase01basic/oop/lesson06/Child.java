package phase01basic.oop.lesson06;

public class Child extends Parent {
     public void test() {
        //  正確！子類別可以直接存取父類別的 protected 屬性與方法
        System.out.println(familySecret); 
        showSecret(); 
    }
}
