package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {

    public static final int WITHDRAWAL_FEE_THRESHOLD = 100;
    public static final int WITHDRAW_FEE = 1;
    private BronzeBankAccount account;

    @BeforeEach
    void init(){
        super.init();
        this.account = new BronzeBankAccount(bankAccount);
    }

    @Test
    public void testCanWithdrawWithFee(){
        this.account.deposit(1000);
        this.account.withdraw(WITHDRAWAL_FEE_THRESHOLD+WITHDRAW_FEE);
        assertEquals(899, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithoutFee(){
        this.account.deposit(1000);
        this.account.withdraw(WITHDRAWAL_FEE_THRESHOLD-WITHDRAW_FEE);
        assertEquals(901, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}