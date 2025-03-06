package e1;

public class BankAccountDecorator implements BankAccount{
    protected final BankAccount decoratedAccount;
    private final WithdrawalPolicy withdrawPolicy;
    private final FeePolicy feePolicy;

    public BankAccountDecorator(BankAccount decoratedAccount, WithdrawalPolicy withdrawPolicy, FeePolicy feePolicy) {
        this.decoratedAccount = decoratedAccount;
        this.withdrawPolicy = withdrawPolicy;
        this.feePolicy = feePolicy;
    }

    @Override
    public int getBalance() {
        return decoratedAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        withdrawPolicy.validateWithdrawal(decoratedAccount.getBalance(), amount);
        int fee = feePolicy.calculateFee(amount);
        decoratedAccount.withdraw(amount + fee);
    }
}
