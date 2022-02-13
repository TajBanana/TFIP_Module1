public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Will Smith",100.00f);
        System.out.println(bankAccount.getName());
        System.out.println(bankAccount.getAccountNumber());

        bankAccount.deposit(50);
        bankAccount.withdraw(25);
        System.out.println();

        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("Jade Smith",1000);
        System.out.println(fixedDepositAccount.getName());
        System.out.println(fixedDepositAccount.getAccountBalance());
        fixedDepositAccount.setInterest(1);
        System.out.println();
    }
}