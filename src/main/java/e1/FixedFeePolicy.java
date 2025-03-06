package e1;

public class FixedFeePolicy implements FeePolicy{
    private final int fee;

    public FixedFeePolicy(int fee) {
        this.fee = fee;
    }

    @Override
    public int calculateFee(int amount) {
        return fee;
    }
}
