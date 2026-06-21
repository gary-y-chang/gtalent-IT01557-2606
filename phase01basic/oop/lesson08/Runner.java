package phase01basic.oop.lesson08;

public class Runner {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();

        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.print();

        double answer = Operator.ADD.apply(5, 3); // 結果為 8.0
        System.out.println("加法計算結果: " + answer);

        answer = Operator.MULTIPLY.apply(5, 3); // 結果為 15.0
        System.out.println("乘法計算結果: " + answer);
    }
}
