public class Exceptions {
    public static void main(String[] args) {
        int a = 23;
        int b = 2;
        try {
            double num = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("yay");
        }
    }
}
