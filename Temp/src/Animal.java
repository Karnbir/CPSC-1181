public abstract class Animal {
    private double weight;
    private AnimalMovement movement;
    private AnimalType type;
    public enum AnimalMovement {WALK,SWIM,CRAWL,FLY};
    public enum AnimalType {MAMMAL,REPTILE,BIRD,INSECT};

    public Animal(double weight, AnimalMovement movement, AnimalType type) {
        this.weight = weight;
        this.movement = movement;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public AnimalMovement howTheyMove() {
        return movement;
    }

    public AnimalType getAnimalType() {
        return type;
    }

    public String toString() {
        return weight + ", " + movement + ", " + type;
    }
}
