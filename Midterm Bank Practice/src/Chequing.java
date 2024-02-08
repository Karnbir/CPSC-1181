public class Chequing extends BankAccount {

    private int transactionLimit;

    public Chequing(double balance) {
        super(balance);
        transactionLimit = 5;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdrawl(double amount) {
        if (transactionLimit <= 0) {
            throw new BankAccountException("ERROR: You have exceeded your withdrawls");
        }
        if (balance < amount) {
            throw new BankAccountException("ERROR: You're broke!");
        }
        balance -= amount;
        transactionLimit--;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + " Transactions Left: " + transactionLimit;
    }
}
