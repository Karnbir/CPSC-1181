public class BankTest {
    public static void main(String[] args)
    {
        Bank firstBankOfJava = new Bank();

        double threshold = 15000;
        int c, accountNumber;
        BankAccount a, max;

        firstBankOfJava.addAccount(new BankAccount(1001, 20000));
        firstBankOfJava.addAccount(new BankAccount(1015, 10000));
        firstBankOfJava.addAccount(new BankAccount(1729, 15000));

        System.out.println("Total balance is: " + firstBankOfJava.getTotalBalance());

        c = firstBankOfJava.count(threshold);
        System.out.println(c + " accounts with balance >= " + threshold);

        accountNumber = 1015;
        a = firstBankOfJava.find(accountNumber);
        if( a == null)
            System.out.println("\nNo account with account number " + accountNumber );
        else
            System.out.println("\nAccount with account number " + accountNumber
                    + " has balance " + a.getBalance());

        max = firstBankOfJava.getMaximum();
        System.out.println("\nAccount with number " + max.getAccountNumber() +
                " has the largest balance.");

        System.out.println(firstBankOfJava);
    }
}
