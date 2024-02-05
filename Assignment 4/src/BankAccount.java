public class BankAccount {
    private double balance;
    private int accountNumber;

    /**
     * Default constructor to generate bank account with no balance
     * @param anAccountNumber is an integer to refer to the bank account by account number
     */
    public BankAccount(int anAccountNumber){
        if (anAccountNumber > 9999 || anAccountNumber < 1000) {
            throw new BankAccountException("ERROR: Account Number must be 4 digits long");
        }
        balance = 0;
        accountNumber = anAccountNumber;
    }

    /**
     * Constructor to generate a bank account with a starting balance
     * @param anAccountNumber is an integer to refer to the bank account by account number
     * @param initialBalance is the initial deposit to the bank account
     */
    public BankAccount(int anAccountNumber, double initialBalance){
        if (anAccountNumber > 9999 || anAccountNumber < 1000) {
            throw new BankAccountException("ERROR: Account Number must be 4 digits long");
        }
        if (initialBalance < 0) {
            throw new BankAccountException("ERROR: Initial Balance must be greater than 0");
        }
        balance = initialBalance;
        accountNumber = anAccountNumber;
    }

    /**
     * Get the balance of a bank account object
     * @return balance as a double
     */
    public double getBalance() {

        return balance;
    }

    /**
     * Get the account number of a bank account object
     * @return account number as an integer
     */
    public int getAccountNumber(){

        return accountNumber;
    }

    /**
     * Allows you to add to the balance of the bank account
     * @param amount is the amount you wish to add to the balance
     */
    public void deposit(double amount){
        if (amount < 0) {
            throw new BankAccountException("ERROR: Negative values not allowed");
        }

        balance += amount;
    }

    /**
     * Allows you to remove from the balance of the bank account
     * @param amount is the amount you wish to remove
     */
    public void withdraw(double amount){
        if (amount > balance) {
            throw new BankAccountException("ERROR: Withdraw amount exceeds balance");
        }
        if (amount < 0) {
            throw new BankAccountException("ERROR: Negative values not allowed");
        }

        balance -= amount;
    }

    /**
     * Prints information about the bank account, will be called whenever put in a print statement
     * @return string with bank account information
     */
    @Override
    public String toString(){

        return "Account Number: " + accountNumber + "  Balance: $" + balance;
    }
}
