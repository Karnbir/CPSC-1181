import javax.swing.JOptionPane;

public class Circle_Lab {
    public static void main (String [] args) {
        double radius;
        String area, circumference;

        boolean repeat;

        do {
            String input = JOptionPane.showInputDialog(null, "Enter a radius: ", "Radius", JOptionPane.PLAIN_MESSAGE);
            radius = Double.parseDouble(input);

            area = String.format("Area: %.2f", areaCalc(radius));
            circumference = String.format("Circumference: %.2f", CircumferenceCalc(radius));


            JOptionPane.showMessageDialog(null, area + "\n" + circumference, "Output", JOptionPane.PLAIN_MESSAGE);

            String[] choice = {"Yes", "No"};

            int option = JOptionPane.showOptionDialog(null, "Would you like to continue?", "Continue?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[1]);

            if (option == 0) {
                repeat = true;
            } else {
                repeat = false;
            }

        } while (repeat);

    }
    public static double areaCalc (double radius) {

        return Math.PI * Math.pow(radius,2);
    }
    public static double CircumferenceCalc (double radius) {

        return 2 * Math.PI * radius;
    }
}