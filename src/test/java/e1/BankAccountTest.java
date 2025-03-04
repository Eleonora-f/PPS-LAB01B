package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    protected BankAccount bankAccount;

    @BeforeEach
    void init(){
        this.bankAccount = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.bankAccount.deposit(1000);
        assertEquals(1000, this.bankAccount.getBalance());
    }

}
