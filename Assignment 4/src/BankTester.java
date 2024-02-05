/**
 * Program Name: BankTester
 * Author: Karnbir Randhawa
 * Course: CPSC 1181
 * Date: January 27, 2024
 * JDK: 21
 */

import java.util.*;
public class BankTester {
    /**
     * This program tests all methods of bank class
     */
    public static void main (String [] args) {

        System.out.println("Welcome to Bank Tester program!");
        Bank eqBank = new Bank(); //eqBank is an object for the Bank class
        boolean repeat = true;

        do {
            System.out.println("""
        \nPlease choose an option below:
        1. Create a Bank Account
        2. Deposit to a Bank Account
        3. Withdraw from a Bank Account
        4. Get the balance of a Bank Account
        5. Find the Bank Account with the highest balance
        6. Find the Bank Account with the lowest balance
        7. Exit program""");

            Scanner input = new Scanner(System.in);
            try {
                int choice = input.nextInt();

                switch (choice) {
                    case (1): createAccount(eqBank); break;
                    case (2): depositToAccount(eqBank); break;
                    case (3): withdrawFromAccount(eqBank); break;
                    case (4): getBalance(eqBank); break;
                    case (5): findHighest(eqBank); break;
                    case (6): findLowest(eqBank); break;
                    case (7): System.out.println("Exiting program");
                        repeat = false;
                        break;
                    default:
                        throw new InputMismatchException(); //throw if number is not on menu
                }
            } catch (BankAccountException exception) {
                System.out.println(exception.getMessage()); //Let bankAccount tell user the error
            } catch (BankException exception) {
                System.out.println(exception.getMessage()); //Let bank tell user the error
            } catch (InputMismatchException exception) { //to catch invalid data entered exception
                System.out.println("ERROR: Please only enter a valid number");
            }
        } while (repeat);

    }

    /**
     * Let user create a bank account in bank class by supplying a valid account number and initial balance
     * @param eqBank is an object of bank
     */
    public static void createAccount(Bank eqBank) {
        System.out.println("To create a bank account, please choose an account number from 1000 - 9999");
        Scanner input = new Scanner(System.in);
        int acc = input.nextInt();

        System.out.println("Please enter an initial balance");
        double balance = input.nextDouble();

        eqBank.addAccount(new BankAccount(acc, balance)); //ask eqbank to generate new bank account
        System.out.println("Congratulations, your bank account has been created! " +
            "\nAccount number = " + acc +
            "\nBalance = " + balance);
    }

    /**
     * Let user read balance of bank account
     * @param eqBank is an object of bank
     */
    public static void getBalance (Bank eqBank) {
        System.out.println("Please enter your bank account number");
        Scanner input = new Scanner(System.in);
        int acc = input.nextInt();
        System.out.println(eqBank.find(acc));
    }

    /**
     * Let user deposit to a bank account
     * @param eqBank is an object of bank
     */
    public static void depositToAccount (Bank eqBank) {
        System.out.println("Please enter your bank account number: ");
        Scanner input = new Scanner(System.in);
        int acc = input.nextInt();

        System.out.println("Please enter how much you would like to deposit: ");
        input = new Scanner(System.in);
        double amount = input.nextDouble();

        eqBank.deposit(amount,acc);
        System.out.println("$" + amount +" has been deposited to account " + acc);
    }

    /**
     * Let user withdraw from a bank account
     * @param eqBank is an object of bank
     */
    public static void withdrawFromAccount (Bank eqBank) {
        System.out.println("Please enter your bank account number: ");
        Scanner input = new Scanner(System.in);
        int acc = input.nextInt();

        System.out.println("Please enter how much you would like to withdraw: ");
        input = new Scanner(System.in);
        double amount = input.nextDouble();

        eqBank.withdraw(amount,acc);
        System.out.println("$" + amount +" has been withdrew from account " + acc);
    }

    /**
     * Print the bank account with the highest balance in bank
     * @param eqBank is an object of bank account
     */
    public static void findHighest (Bank eqBank) {
        System.out.println("The bank account with the highest balance is: " + eqBank.getMaximum());
    }

    /**
     * Print the bank account with the lowest balance in bank
     * @param eqBank is an object of bank account
     */
    public static void findLowest (Bank eqBank) {
        System.out.println("The bank account with the lowest balance is " + eqBank.getMinimum());
    }
}