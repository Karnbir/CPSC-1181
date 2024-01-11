/**
 * Program Name: GuessTheNumber
 * Author: Karnbir Randhawa
 * Date: January 10th, 2024
 * Course: CPSC 1181
 * Compiler: JDK 21
 */

import javax.swing.JOptionPane;

public class GuessTheNumber {
    /**
     * This program guesses a number based on mathematical calculations done to it afterward.
     */
    public static void main (String [] args) {
        int repeat;

        do {
            String[] levels = {"Novice", "Intermediate", "Expert"}; //3 difficulty options

            //get user's desired difficulty setting
            int difficulty = JOptionPane.showOptionDialog(null,
                    "At what level do you want to play", "Select Level",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);

            JOptionPane.showMessageDialog(null,
                    "Think of a number (an integer)\n and I'll guess what that number is",
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

            repeat = JOptionPane.showConfirmDialog(null, "Would you like to play again?",
                    "Continue?",
                    JOptionPane.YES_NO_OPTION);
        } while (repeat == 0);

    }

    /**
     * Novice difficulty setting, relies on InputVerification method to validate input
     */
    public static void Novice () {
        JOptionPane.showMessageDialog(null,"Multiply the answer of \"Step1\" by 10"
                ,"Step2",JOptionPane.PLAIN_MESSAGE);
        String input = JOptionPane.showInputDialog(null,"Give me the result of your calculations",
                "Type your number", JOptionPane.QUESTION_MESSAGE);

        boolean validInput = InputVerification(input);
        //undo all math operations to correctly guess number
        if (validInput){
            double num = Double.parseDouble(input);
            num = num / 10;
            JOptionPane.showMessageDialog(null,"my guess for your number is " + num,
                    "My guess",JOptionPane.PLAIN_MESSAGE);
        }
    }
    /**
     * Intermediate difficulty setting, relies on InputVerification method to validate input
     */
    public static void Intermediate() {
        JOptionPane.showMessageDialog(null,"Multiply the answer of \"Step1\" by 10"
                ,"Step2",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Add 5 to your answer from \"Step2\""
                ,"Step3",JOptionPane.PLAIN_MESSAGE);
        String input = JOptionPane.showInputDialog(null,"Give me the result of your calculations",
                "Type your number", JOptionPane.QUESTION_MESSAGE);

        boolean validInput = InputVerification(input);

        //undo all math operations to correctly guess number
        if (validInput){
            double num = Double.parseDouble(input);
            num = num - 5;
            num = num / 10;
            JOptionPane.showMessageDialog(null,"my guess for your number is " + num,
                    "My guess",JOptionPane.PLAIN_MESSAGE);
        }
    }
    /**
     * Expert difficulty setting, relies on InputVerification method to validate input
     */
    public static void Expert() {
        //guide user to perform 3 mathematical operations on their number
        JOptionPane.showMessageDialog(null,"Multiply the answer of \"Step1\" by 10"
                ,"Step2",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Add 5 to your answer from \"Step2\""
                ,"Step3",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Subtract 2 from your answer for \"Step3\""
                ,"Step4",JOptionPane.PLAIN_MESSAGE);
        String input = JOptionPane.showInputDialog(null,"Give me the result of your calculations",
                "Type your number", JOptionPane.QUESTION_MESSAGE);

        boolean validInput = InputVerification(input);
        //undo all math operations to correctly guess number
        if (validInput){
            double num = Double.parseDouble(input);
            num = num + 2;
            num = num - 5;
            num = num / 10;
            JOptionPane.showMessageDialog(null,"my guess for your number is " + num,
                    "My guess",JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Checks if input is valid my processing the input through a series of tests
     * @param input is user's a number after user has performed mathematical operations on their number
     * @return true or false if input if valid
     */
    public static boolean InputVerification (String input) {
        //error handling if user presses cancel
        if (input == null) {
            JOptionPane.showMessageDialog(null,"CANCEL was requested - nothing is done",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //empty input case
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null,"result of \"" + input + "\" is invalid",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //validates if input only contains numbers
        boolean negativeCheck = false;
        for (int i = 0; i < input.length(); i++) {
            if (!negativeCheck) {
                if (input.charAt(0) == '-') { //allow a "-" for negative values only at beginning of input (e.g. -2)
                    negativeCheck = true;
                    i++;
                }
            }
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                JOptionPane.showMessageDialog(null,"result of \"" + input + "\" is invalid",
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true; //return true if all input validation checks pass
    }
}