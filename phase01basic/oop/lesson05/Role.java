package phase01basic.oop.lesson05;

public enum Role {
    ADMIN("管理員", 99),
    MANAGER("經理", 80),
    USER("使用者", 50),
    GUEST("訪客", 15);

    private String label;
    private int level;

    Role(String label, int level) {
        this.label = label;
        this.level = level;
    }

    public String getLabel() {
        return label;
    }

    public int getLevel() {
        return level;
    }

    public static Role fromLabel(String label) {
        for (Role role : Role.values()) {
            if (role.getLabel().equals(label)) {
                return role;
            }
        }
        return null; // 或 throw new IllegalArgumentException("No role with label: " + label);
    }
}
