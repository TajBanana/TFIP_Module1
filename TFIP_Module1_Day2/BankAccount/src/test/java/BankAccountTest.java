import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount bankAccount = new BankAccount("Will Smith",50);

    @Test
    @DisplayName("Deposit into account")
    void deposit() {
        bankAccount.deposit(50);
        assertEquals(bankAccount.getAccountBalance(),100f);
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(50);
        assertEquals(bankAccount.getAccountBalance(), 0f);
    }
}