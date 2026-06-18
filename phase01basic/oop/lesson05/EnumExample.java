package phase01basic.oop.lesson05;

public class EnumExample {
    
    public static void main(String[] args) {
        Role admin = Role.ADMIN;
        System.out.println("Role: " + admin.getLabel() + ", Level: " + admin.getLevel());

        for(Role role : Role.values()) {
            if(role.ordinal() == 1) {
                System.out.println(role.name() + " - " + role.getLabel() + " (Level " + role.getLevel() + ")");
            }
        }

        // Role.valueOf("銷售").getLevel();  // 2

        Role role = Role.fromLabel("銷售");
        if (role != null) {
            System.out.println("Role with label: " + role.getLabel());
        } else {
            System.out.println("No role found with label '銷售'");
        }
    }
}
