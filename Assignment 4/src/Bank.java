import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    /**
     * Initializes the bank as an arraylist to contain BankAccount objects
     */
    public Bank()
    {
        accounts = new ArrayList<BankAccount>();
    }

    /**
     * Adds a BankAccount to the accounts arraylist
     * @param a BankAccount object
     */
    public void addAccount(BankAccount a)
    {
        accounts.add(a);
    }

    /**
     * Deposit an amount to a bank account identified by accountNumber
     * @param amount the deposit amount
     * @param accountNumber the number for the bank account to add to
     */
    public void deposit (double amount,int accountNumber) {
        BankAccount a = find(accountNumber);
        a.deposit(amount);
    }

    /**
     * Withdraw an amount from a bank account identified by accountNumber
     * @param amount the withdrawal amount
     * @param accountNumber for the bank account to add to
     */
    public void withdraw (double amount, int accountNumber) {
        BankAccount a = find(accountNumber);
        a.withdraw(amount);
    }

    /**
     * Get the collective balance of all bank accounts in the accounts arraylist
     * @return the collective balance
     */
    public double getTotalBalance()
    {
        double total = 0;
        for(BankAccount a : accounts)
        {
            total = total + a.getBalance();
        }
        return total;
    }

    /**
     Counts the number of bank accounts whose balance is at least a given value.
     @param atLeast the balance required to count an account
     @return the number of accounts having least the given balance
     */
    public int count(double atLeast)
    {
        int matches = 0;

        for(BankAccount a : accounts)
        {
            if (a.getBalance() >= atLeast)
                matches++;
        }
        return matches;
    }

    /**
     Finds a bank account with a given number.
     @param accountNumber the number to find
     @return the account with the given number, or throw exception if account not found
     */
    public BankAccount find(int accountNumber)
    {
        for(BankAccount a : accounts)
        {
            if (a.getAccountNumber() == accountNumber)
                return a;
        }
        throw new BankException("ERROR: Bank Account not found");
    }

    /**
     Gets the bank account with the largest balance.
     @return the account with the largest balance, or throw exception if the bank has no accounts
     */
    public BankAccount getMaximum()
    {
        if (accounts.size() == 0) {
            throw new BankException("ERROR: No Bank Accounts Found!");
        }

        BankAccount largest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {
            BankAccount a = accounts.get(i);
            if (a.getBalance() > largest.getBalance())
                largest = a;
        }
        return largest;
    }

    /**
     Gets the bank account with the smallest balance.
     @return the account with the smallest balance, or throw exception if the bank has no accounts
     */
    public BankAccount getMinimum() {
        if (accounts.size() == 0) {
            throw new BankException("ERROR: No Bank Accounts Found!");
        }

        BankAccount smallest = accounts.get(0);

        for (BankAccount x : accounts) {
            if (x.getBalance() < smallest.getBalance()) {
                smallest = x;
            }
        }
        return smallest;
    }

    /**
     * Prints entire contents of accounts arraylist (all bank accounts in bank)
     * @return accountnumber & balance for each account in bank as string as defined in bankAccount class
     */
    @Override
    public String toString()
    {
        return "Bank " + accounts.toString();
    }
}
