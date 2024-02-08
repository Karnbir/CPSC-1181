import java.util.ArrayList;

public class AnimalTester {
    public static void main(String[] args){
        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(new Dog(70, Animal.AnimalMovement.WALK, Animal.AnimalType.MAMMAL, "Husky"));
        animals.add(new Snake(20, Animal.AnimalMovement.SWIM, Animal.AnimalType.REPTILE, "Sea Snake", false));
        animals.add(new Dog(50, Animal.AnimalMovement.WALK, Animal.AnimalType.MAMMAL,"Poodle"));
        animals.add(new Snake(68, Animal.AnimalMovement.CRAWL, Animal.AnimalType.REPTILE, "King Cobra", true));
        animals.add(new Snake(15, Animal.AnimalMovement.CRAWL, Animal.AnimalType.REPTILE, "Garden Snake", false));

        System.out.println(animals);
    }
}
