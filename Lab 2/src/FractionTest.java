import java.util.*;
public class FractionTest {
    public static void main(String [] args) {
        boolean repeat;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the numerator for Fraction 1: ");
            int num1 = input.nextInt();
            while (!verifyInput(num1)) {
                System.out.println("Please only enter a positive numerator for Fraction 1: ");
                num1 = input.nextInt();
            }
            System.out.println("Please enter the denominator for Fraction 1: ");
            int denom1 = input.nextInt();
            while (!verifyInput(denom1)) {
                System.out.println("Please only enter a positive denominator for Fraction 1: ");
                denom1 = input.nextInt();
            }
            System.out.println("Please enter the numerator for Fraction 2: ");
            int num2 = input.nextInt();
            while (!verifyInput(num2)) {
                System.out.println("Please only enter a positive numerator for Fraction 2: ");
                num2 = input.nextInt();
            }
            System.out.println("Please enter the denominator for Fraction 2: ");
            int denom2 = input.nextInt();
            while (!verifyInput(denom2)) {
                System.out.println("Please only enter a positive denominator for Fraction 2: ");
                denom2 = input.nextInt();
            }

            Fraction f1 = new Fraction(num1, denom1);
            Fraction f2 = new Fraction(num2, denom2);
            Fraction f3 = new Fraction();

            f3 = f1.add(f2);
            System.out.println("Addition: " + f3.toString());
            f3 = f1.multiply(f2);
            System.out.println("Multiplication: " + f3.toString());
            f3 = f1.subtract(f2);
            System.out.println("Subtraction: " + f3.toString());


            System.out.println("Would you like to run the program again? Yes or No?");
            input = new Scanner(System.in);
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("Y")) {
                repeat = true;
            }
            else {
                repeat = false;
            }
        } while (repeat);
    }

    public static boolean verifyInput(int input) {
        if (input >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}