package phase01basic.oop.lesson09;

public class ValidationException extends Exception {
    private final String field;

    public ValidationException(String field, String msg) {
        super("[" + field + "] " + msg);
        this.field = field;
    }

    public String getField() { return field; }
}
