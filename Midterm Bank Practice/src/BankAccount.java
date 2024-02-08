public abstract class BankAccount {

    private int accountnum;
    private static int nextAccountNum = 101;

    protected double balance;

    public BankAccount(double balance) {
        accountnum = nextAccountNum++;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdrawl(double amount);

    public int getAccountnum () {
        return accountnum;
    }

    @Override
    public String toString() {
        return getClass().getName() + "Account number: " + accountnum + " Balance: " + balance;
    }
}
