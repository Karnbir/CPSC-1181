public class Bank {
    private BankAccount[] accounts;
    private int pos_to_add;
    private static int MAX_SIZE = 100;

    public Bank()
    {
        accounts = new BankAccount[MAX_SIZE];
        pos_to_add = 0;
    }

    public void addAccount(BankAccount a)
    {
        if (pos_to_add < accounts.length)
        {
            accounts[pos_to_add] = a;
            pos_to_add++;
        }
        else
        {
            //copy accounts into a bigger array
            System.out.println("accounts need to grow...");
        }
    }

    public double getTotalBalance()
    {
        double total = 0;
        BankAccount a;
        for(int i = 0; i < pos_to_add; i++)
        {
            a = accounts[i];
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

        BankAccount a;
        for(int i = 0; i < pos_to_add; i++)
        {
            a = accounts[i];
            if (a.getBalance() >= atLeast)
                matches++;
        }
        return matches;
    }

    /**
     Finds a bank account with a given number.
     @param accountNumber the number to find
     @return the account with the given number, or null if there is no such account
     */
    public BankAccount find(int accountNumber)
    {
        BankAccount a;
        for(int i = 0; i < pos_to_add; i++)
        {
            a = accounts[i];
            if (a.getAccountNumber() == accountNumber)
                return a;
        }
        return null;
    }

    /**
     Gets the bank account with the largest balance.
     @return the account with the largest balance, or null if the bank has no accounts
     */
    public BankAccount getMaximum()
    {
        if (pos_to_add == 0)
            return null;

        BankAccount largest = accounts[0];

        for (int i = 1; i < pos_to_add; i++)
        {
            BankAccount a = accounts[i];
            if (a.getBalance() > largest.getBalance())
                largest = a;
        }
        return largest;
    }

    public String toString()
    {
        return "Bank " + accounts.toString();
    }

}
