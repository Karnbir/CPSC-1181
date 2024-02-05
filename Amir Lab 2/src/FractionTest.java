public class FractionTest {
    /**
     ** Program Name: Fraction and Fraction test class
     ** Author: Hossein Toutounchi
     ** Date: Jan 12th, 2023
     ** Course: CPSC 1181
     ** Compiler: JDK 20.0.2
     */
    public static void main(String[] args)
    {

        System.out.println("Testing the Fraction class");
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(1,3);
        System.out.println("Expected value for numerator is 0 and denominator 1");
        System.out.println("Stored value for numerator is " + f1.numerator + " and denominator is " + f1.denominator);
        System.out.println("Expected value for numerator is 1 and 3");
        System.out.println("Stored value for numerator is " + f2.numerator + " and denominator is " + f2.denominator);

        Fraction f3 = f1.add(f2);
        System.out.println("Expected value for numerator is 1 and denominator 3");
        System.out.println("Stored value for numerator is " + f3.numerator + " and denominator is " + f3.denominator);

        Fraction f4 = f1.multiply(f2);
        System.out.println("Expected value for numerator is 0 and denominator 3");
        System.out.println("Stored value for numerator is " + f4.numerator + " and denominator is " + f4.denominator);

        Fraction f5 = f1.subtract(f2);
        System.out.println("Expected value for numerator is -1 and denominator 3");
        System.out.println("Stored value for numerator is " + f5.numerator + " and denominator is " + f5.denominator);

        System.out.println("Expected value for numerator is 0 and denominator 1");
        System.out.println(f1.toString());
        System.out.println("Expected value for numerator is 1 and denominator 3");
        System.out.println(f2.toString());

    }
}