public class BedroomTester {

    public static void main (String [] args) {
        Room b1 = new Bedroom(1,1,true);

        Room b4 = new Bedroom(5,5,false);

        int y = 2;

        try {
            System.out.println(b4.getArea());
            System.out.println(b1.getArea());

        } catch (Exception e) {
            System.out.println("Exception caught");
        }

        Room b2 = new Bedroom (1,1,true);
        Room b3 = new Bedroom(1,1,false);

        if (b1.equals(b2)) {
            System.out.println("equals works");
        }
        if (b1.equals(b3)) {
            System.out.println("equals doesn't work");
        }

        if (b1.equals(y)) {
            System.out.println("equals doesn't work");
        }

    }
}