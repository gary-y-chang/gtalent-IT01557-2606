package phase01basic.oop.lesson08;

public enum Operator implements Calculator {
    ADD {
        @Override
        public double apply(double x, double y) { return x + y; }
    },
    SUBTRACT {
        @Override
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) { return x / y; }
    }
    
}
