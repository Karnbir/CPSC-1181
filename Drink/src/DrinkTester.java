
public class DrinkTester {
    public static void main(String arg[]) {
        Drink a = new Malt();
        System.out.println(a); //memory addresss


        Drink b = new FruitSmoothie (true); //has protien
        FruitSmoothie fs = (FruitSmoothie) b; //cast back into real form
        System.out.println(fs.reaction()); //this fruitsmoothie with protien tastes good and is healthy


       Drink c = new FruitSmoothie(true); //has protien
       //System.out.println(c.getHasProtein()); //error, doesnt have the method


       //Drink d= new Drink();
       //System.out.println(d.toString()); //error cant make cuz abstract

       //Malt e = new MilkShake();
       //System. out.println(e.reaction()); //cant view child as parent

        Drink f = new FruitSmoothie(false);
        System.out.println(f.getType()); //fruit smoothie
    }
}
