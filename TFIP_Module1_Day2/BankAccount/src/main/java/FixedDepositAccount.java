import java.util.ArrayList;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3.0f;
    private int duration = 6;
    private boolean hasInterestChanged = false;
    private boolean hasDurationChanged = false;

//    --------------------------------------------------------------------------------------------   CONSTRUCTOR
    public FixedDepositAccount(String name) {
        super(name);
    }

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
    }

    public FixedDepositAccount(String name, float balance,float interest) {
        super(name, balance);
        this.interest = interest;
        this.hasInterestChanged =true;
    }

    public FixedDepositAccount(String name, float balance,float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
        this.hasInterestChanged =true;
        this.hasDurationChanged = true;
    }
//    --------------------------------------------------------------------------------------------   GETTER SETTER

    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }


//    --------------------------------------------------------------------------------------------   CLASS METHOD

    @Override
    public void deposit(float amount) {
    }

    @Override
    public void withdraw(float amount){
    }

    public void setInterest(float interest) {

        if (hasInterestChanged) throw new IllegalArgumentException();

        this.interest = interest;
        hasInterestChanged = true;
    }

    public void setDurationInMonths(int duration) {
        if(hasDurationChanged) throw new IllegalArgumentException();
        this.duration = duration;
        hasDurationChanged = true;
    }

}
