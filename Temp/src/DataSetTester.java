public class DataSetTester {
    public static void main(String[] args) {
        DataSet bankData = new DataSet();

        bankData.add(new Account(200));
        bankData.add(new Account());
        bankData.add(new Account(100.25));
        bankData.add(new Account(15.25));
        bankData.add(new Account(1000.25));

        System.out.println("Average balance = "
                + bankData.getAverage());

        Measurable max = bankData.getMaximum();
        System.out.println("Highest balance = "
                + max.getMeasure());

        Account acc = (Account) max;
        System.out.println("Look at this one" + acc.withdraw(5.0));
        System.out.println("Look at this one " + max);
        System.out.println("Account with the highest balance = "
                + acc.getBalance());
        System.out.println("Max = " + acc);
    }
}
