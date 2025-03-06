package e1;

public interface WithdrawalPolicy {
    void validateWithdrawal(int balance, int amount);
}
