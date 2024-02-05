public class BankAccount {
    private double balance;
    private int accountNumber;

    public BankAccount(int anAccountNumber){

        balance = 0;
        accountNumber = anAccountNumber;
    }

    public BankAccount(int anAccountNumber, double initialBalance){

        balance = initialBalance;
        accountNumber = anAccountNumber;
    }

    public double getBalance() {

        return balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount){

        balance += amount;
    }

    public void withdraw(double amount){

        balance -= amount;
    }

    @Override
    public String toString(){

        return "Account Number: " + accountNumber + "  balance: " + balance;
    }
}
