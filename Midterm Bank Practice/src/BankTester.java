import java.util.*;
public class BankTester {

    public static void main(String [] args) {
        Bank td = new Bank();
        boolean repeat = true;
        do {
            System.out.println("""
                    \nHello please enter a bank account type you want:
                    1. Chequing
                    2. Savings
                    3. I'm done making new accounts""");
            try {
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                System.out.println("Enter an initial balance");
                input = new Scanner(System.in);
                double balance = input.nextDouble();
                switch (choice) {
                    case (1):
                        td.accountType(Bank.AccountType.CHEQUING, balance);
                        break;
                    case (2):
                        td.accountType(Bank.AccountType.SAVINGS, balance);
                        break;
                    case (3):
                        repeat = false;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please only enter 1 or 2");
            }
            System.out.println(td);
        } while (repeat);
        repeat = true;
        do {
            System.out.println("""
                    What do u wanna do:
                    1. Deposit
                    2. Withrawl
                    3. Exit""");
            try {
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice) {
                    case (1):
                        System.out.println("Enter your account number");
                        input = new Scanner(System.in);
                        int acc = input.nextInt();
                        BankAccount temp = td.getAccount(acc);
                        System.out.println("Enter your deposit amount");
                        input = new Scanner(System.in);
                        double amount = input.nextDouble();
                        temp.deposit(amount);
                        break;
                    case (2):
                        System.out.println("Enter your account number");
                        input = new Scanner(System.in);
                        acc = input.nextInt();
                        temp = td.getAccount(acc);
                        System.out.println("Enter your withdraw amount");
                        input = new Scanner(System.in);
                        amount = input.nextDouble();
                        temp.withdrawl(amount);
                        break;
                    case (3): repeat = false; break;
                    default:
                        throw new InputMismatchException();
                }
                System.out.println("Bank State: " + td);
            } catch (InputMismatchException e) {
                System.out.println("Please only enter 1,2 or 3");
            } catch (BankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (repeat);
    }
}
