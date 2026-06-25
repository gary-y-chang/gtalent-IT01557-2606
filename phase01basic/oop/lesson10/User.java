package phase01basic.oop.lesson10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class User  {
    
    int age;
    String name;
    
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() { return name + "(" + age + ")"; }

    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User(25, "Bob"), 
                                        new User(30, "Alice"),
                                        new User(20, "Charlie"));

        // 按年齡升序排序 (使用 Lambda)
        list.sort((u1, u2) -> Integer.compare(u1.age, u2.age));
        list.sort(Comparator.comparing(u -> u.age));
        
        
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u1.age, u2.age);
                // return s1.name.compareTo(s2.name);
            }
        }); 


        System.out.println(list);
    }
}

