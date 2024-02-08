public class Saving extends BankAccount{
    private double interestRate = 1.05;

    public Saving(double balance) {
        super(balance);
        super.balance = balance * interestRate;
    }

    public void deposit(double amount) {
        balance += amount * interestRate;
    }
    @Override
    public void withdrawl(double amount) {
        if (balance < amount * interestRate) {
            throw new BankAccountException("ERROR: You're broke");
        }
        balance -= amount * interestRate;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + " Interest Rate: " + interestRate;
    }
}
