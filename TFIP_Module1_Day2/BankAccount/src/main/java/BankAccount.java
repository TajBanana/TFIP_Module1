import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private String name;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean closed;
    private Date accountCreateDate;
    private Date accountClosedDate;

//    --------------------------------------------------------------------------------------------   CONSTRUCTOR

    public BankAccount(String name) {
        this.name = name;
        this.accountBalance = 0f;
        this.accountNumber = Integer.toString((int) (Math.random()*1000000000));
        this.transactions = new ArrayList<>();
        this.closed = false;
/*
        this.accountCreateDate = ;
        this.accountClosedDate = ;*/
    }

    public BankAccount(String name, float accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.accountNumber = Integer.toString((int) (Math.random()*1000000000));
        this.transactions = new ArrayList<>();
        this.closed = false;
/*
        this.accountCreateDate = ;
        this.accountClosedDate = ;*/
    }

//    --------------------------------------------------------------------------------------------   GETTER SETTER

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return closed;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public Date getAccountClosedDate() {
        return accountClosedDate;
    }

//    --------------------------------------------------------------------------------------------   CLASS METHOD

    public void deposit(float amount) {

 /*       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now).getClass().getSimpleName());*/
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be larger than $0");
        } else {
            String transaction = "Deposited " + amount + " at " + Calendar.getInstance().getTime();
            transactions.add(transaction);
            this.accountBalance += amount;

            System.out.println(transactions);
            System.out.println(accountBalance);
        }

    }

    public void withdraw(float amount) {

        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be larger than $0");
        } else {
            String transaction = "Withdraw " + amount + " at " + Calendar.getInstance().getTime();
            transactions.add(transaction);
            this.accountBalance -= amount;

            System.out.println(transactions);
            System.out.println(accountBalance);
        }
    }
}