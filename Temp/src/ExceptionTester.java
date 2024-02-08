import java.util.*;
public class ExceptionTester {

    public static void main (String [] args) {
        System.out.println("Type anything and i'll tell you what u typed");

        try {
            Scanner input = new Scanner(System.in);
            int user = input.nextInt();
            if (user < 0) {
                throw new Exceptionz("No negative numbers bro");
            }
            System.out.println(user);
        } catch (InputMismatchException e) {
            System.out.println("Only integers allowed");
        } catch (Exceptionz e) {
            System.out.println(e.getMessage());
        }
    }
}
