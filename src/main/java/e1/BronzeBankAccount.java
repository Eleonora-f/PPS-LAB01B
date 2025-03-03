package e1;

public class BronzeBankAccount implements BankAccount{

    private BankAccount base;

    public BronzeBankAccount(BankAccount ba) {
        this.base = ba;
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }
}
