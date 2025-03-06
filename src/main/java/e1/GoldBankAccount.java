package e1;

public class GoldBankAccount extends BankAccountDecorator{

    public static final int OVERDRAFT_LIMIT = 100;
    public static final int FEE = 0;
    private BankAccount base;

    public GoldBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount, new OverdraftPolicy(OVERDRAFT_LIMIT), new FixedFeePolicy(FEE));
    }
}
