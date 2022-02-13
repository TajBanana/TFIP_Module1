import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedDepositAccountTest {
    FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("Will Smith", 100);

    @Test
    @DisplayName("Deposit into fixed account")
    void deposit() {
        fixedDepositAccount.deposit(1000);
        assertEquals(fixedDepositAccount.getAccountBalance(),100);
    }

    @Test
    @DisplayName("Withdraw from fixed account")
    void withdraw() {
        fixedDepositAccount.withdraw(1000);
        assertEquals(fixedDepositAccount.getAccountBalance(),100);
    }

    @Test
    @DisplayName("Set and get new interest rate")
    void setInterest() {
        fixedDepositAccount.setInterest(3.5f);
        assertEquals(fixedDepositAccount.getInterest(),3.5);

    }

    @Test
    @DisplayName("Set and get new interest rate")
    void setDurationInMonths() {
        fixedDepositAccount.setDurationInMonths(3);
        assertEquals(fixedDepositAccount.getDuration(),3);
    }
}