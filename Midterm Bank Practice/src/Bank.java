import java.util.ArrayList;
public class Bank {
    private AccountType type;

    public enum AccountType {CHEQUING, SAVINGS};

    private ArrayList<BankAccount> accounts;
    public Bank() {
        accounts = new ArrayList<>();
    }

    public void accountType (AccountType type, double balance) {
        if (type == AccountType.CHEQUING) {
            accounts.add(new Chequing(balance));
        }
        if (type == (AccountType.SAVINGS)) {
            accounts.add(new Saving(balance));
        }
    }

    public BankAccount getAccount(int accountnumber) {
        for (BankAccount x : accounts) {
            if (x.getAccountnum() == accountnumber)
                return x;
        }
        throw new BankAccountException("No account found");
    }

    @Override
    public String toString() {
        String accs = "";
        for (BankAccount x : accounts) {
            accs += x;
        }
        return accs;
    }
}
