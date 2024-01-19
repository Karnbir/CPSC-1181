public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction () {
        numerator = 0;
        denominator = 0;
    }
    public Fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
    }
    public Fraction add(Fraction f) {
        int num = numerator * f.denominator +
                f.numerator * denominator;
        int denom = denominator * f.denominator;
        return new Fraction(num, denom);
    }
    public Fraction multiply (Fraction f) {
        int num = numerator * f.numerator;
        int denom = denominator * f.denominator;
        return new Fraction(num, denom);
    }
    public Fraction subtract(Fraction f) {
        int num = numerator * f.denominator -
                f.numerator * denominator;
        int denom = denominator * f.denominator;
        return new Fraction(num, denom);
    }
    public String toString() {
        return numerator + "/" + denominator;
    }
}