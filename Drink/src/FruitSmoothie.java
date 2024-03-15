public class FruitSmoothie extends Drink {
    private boolean hasProtein;

    public FruitSmoothie(boolean hasProtein) {
        //super();
        this.hasProtein = hasProtein;
    }

    public boolean getHasProtein() {
        return this.hasProtein;
    }

    public String getType() {
        String result = "fruit smoothie";
        if (hasProtein) {
            result += " with protein";
        }
        return result;
    }

    public String reaction() {
        return super.reaction() + " and is healthy";
    }
}