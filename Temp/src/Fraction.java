public class Fraction {
    private int denominator;
    private int numerator;

    public Fraction() {
        numerator = 0;
        denominator = 69;
    }
    public Fraction(int num, int denum) {
        numerator = num;
        denominator = denum;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public Fraction add(Fraction f1) {
        int num = (numerator * f1.denominator) + (f1.numerator * denominator);
        int denum = denominator * f1.denominator;
        return new Fraction(num, denum);
    }
    public String toString () {
        return numerator + " / " + denominator;
    }
}
