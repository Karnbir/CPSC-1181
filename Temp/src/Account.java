public class Account implements Measurable{
    private double balance;
    private int account_number;
    private static int last_account_number = 1001;

    public Account(double initBalance) {
        account_number = last_account_number;
        balance = initBalance;
        last_account_number++;
    }

    public Account( ) {
        account_number = last_account_number;
        balance = 0;
        last_account_number++;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return account_number;
    }

    public String toString() {
        return "account number = " + account_number +
                "\nbalance = " + balance;
    }
    @Override
    public double getMeasure() {
        return balance;
    }
}
