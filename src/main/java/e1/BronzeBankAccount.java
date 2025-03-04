package e1;

public class BronzeBankAccount implements BankAccount{

    public static final int WITHDRAW_FEE = 1;
    public static final int WITHDRAW_FEE_THRESHOLD = 100;
    private final BankAccount base;

    public BronzeBankAccount(BankAccount ba) {
        this.base = ba;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount > base.getBalance()) {
            throw new IllegalStateException();
        }
        base.withdraw(amount < WITHDRAW_FEE_THRESHOLD ? amount : amount + WITHDRAW_FEE);
    }
}
