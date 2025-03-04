package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest{

    private GoldBankAccount account;

    @BeforeEach
    void init(){
        super.init();
        this.account = new GoldBankAccount(bankAccount);
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        this.account.withdraw(1500);
        assertEquals(-500, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverdraft() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(2000));
    }
}
