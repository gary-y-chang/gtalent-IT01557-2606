package phase01basic.oop.lesson10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PECS {
    // <? extends T> 代表 T 或其子類別，這是生產者（被讀取），用 extends
    // <? super T> 代表 T 或其父類別，這是消費者（被寫入），用 super

    public static void readAnimals(List<? extends Animal> cage){
        for(Animal a : cage){
            switch (a) {
                case Puppy pp -> System.out.println("This is Puppy with legs: " + pp.getLegs() + " sound: " + pp.getSound());
                case Dog dd -> System.out.println("This is Dog with legs: " + dd.getLegs());
                case Animal ani ->  System.out.println("This is Animal with legs: " + ani.getLegs());
            }
            System.out.println(a.getClass());
        }

        // cage.add(new Dog()); 
        // cannot add to a List<? extends Animal> because we don't know what specific subtype of Animal the list is holding. 
        // It could be a List<Dog>, List<Puppy>, etc., and adding a Dog to a List<Puppy> would violate type safety.
    }
    
    public static void addDogs(List<? super Dog> dogs, Dog dd){
        // safe to write a Dog to a List<? super Dog> because the list 
        // is guaranteed to be able to hold Dog objects or any of its supertypes (like Animal).
        dogs.add(dd);
   
        // Animal d = dogs.get(0);
        Object dd1 = dogs.get(0);
        System.out.println(dd1.toString());

        Iterator<? super Dog> gg = dogs.iterator();
        while (gg.hasNext()) {
            System.out.println(gg.next().getClass());      
        }
      
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Puppy("barking"));
        animals.add(new Dog());
        readAnimals(animals);
        addDogs(animals, new Dog());
        System.out.println("------------------------");

        // List<Dog> dogs = new ArrayList<>();
        // dogs.add(new Dog());
        // addDogs(dogs, null);
        // readAnimals(dogs);
        
        // System.out.println("------------------------");
        
        // cannot add a subtype of Dog to a List<? super Dog> 
        // List<Puppy> ppy = new ArrayList<>();
        // ppy.add(new Puppy(null));
        // addDogs(ppy, new Puppy("null"));

        
    }

}
