public class Dog extends Animal{

    private String breed;

    public Dog(double weight, AnimalMovement movement, AnimalType type, String breed) {
        super(weight,movement,type);
        this.breed = breed;
    }

}
