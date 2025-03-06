package e1;

public class OverdraftPolicy implements WithdrawalPolicy{
    private final int overdraftLimit;

    public OverdraftPolicy(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void validateWithdrawal(int balance, int amount) {
        if(amount - balance < overdraftLimit) {
            throw new IllegalStateException();
        }
    }
}
