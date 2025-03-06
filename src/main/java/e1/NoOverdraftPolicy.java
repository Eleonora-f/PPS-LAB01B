package e1;

public class NoOverdraftPolicy implements WithdrawalPolicy{
    @Override
    public void validateWithdrawal(int balance, int amount) {
        if (balance < amount) {
            throw new IllegalStateException();
        }
    }
}
