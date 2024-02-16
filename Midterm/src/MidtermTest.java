public class MidtermTest {

    public static void main (String [] args) throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Catched 1st");
            throw new Exception();
        }
        finally {
            System.out.println("If this shows I'm right");
        }
    }
}
