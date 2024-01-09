/**
 *
 */

import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main (String [] args) {
        int repeat;


        do {
            String[] levels = {"Novice", "Intermediate", "Expert"}; //give options to user

            //get user's desired difficulty setting
            int difficulty = JOptionPane.showOptionDialog(null, "At what level do you want to play", "Select Level",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);

            JOptionPane.showMessageDialog(null, "Think of a number (an integer)\n and I'll guess what that number is",
                    "Step1", JOptionPane.PLAIN_MESSAGE);

            switch (difficulty) {
                case 0:
                    Novice();
                    break;
                case 1:
                    Intermediate();
                    break;
                case 2:
                    Expert();
                    break;
            }

            repeat = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Continue?",
                    JOptionPane.YES_NO_OPTION);
        } while (repeat == 0);

    }
    public static void Novice () {
        JOptionPane.showMessageDialog(null,"Multiply the answer of \"Step1\" by 10"
                ,"Step2",JOptionPane.PLAIN_MESSAGE);
        String input = JOptionPane.showInputDialog(null,"Give me the result of your calculations","Type your number", JOptionPane.QUESTION_MESSAGE);

        boolean validInput = InputVerification(input);

        if (validInput){
            double num = Double.parseDouble(input);
            num = num / 10;
            JOptionPane.showMessageDialog(null,"my guess for your number is " + num,"My guess",JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static void Intermediate() {}
    public static void Expert() {}

    public static boolean InputVerification (String input) {
        if (input == null) { //error handling if user presses cancel
            JOptionPane.showMessageDialog(null,"CANCEL was requested - nothing is done","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (input.length() < 1) { //empty input case
            JOptionPane.showMessageDialog(null,"result of \"" + input + "\" is invalid","ERROR",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (int i = 0; i < input.length(); i++) { //non-digit input case
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                JOptionPane.showMessageDialog(null,"result of \"" + input + "\" is invalid","ERROR",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
