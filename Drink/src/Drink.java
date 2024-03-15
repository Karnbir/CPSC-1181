public abstract class Drink {

    public Drink() {};
        public abstract String getType();
        public String reaction() {
            return "This " +this.getType() + " tastes good";
}
    }
