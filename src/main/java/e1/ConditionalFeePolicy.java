package e1;

public class ConditionalFeePolicy implements FeePolicy{

    private final int fee;
    private final int threshold;

    public ConditionalFeePolicy(int fee, int threshold) {
        this.fee = fee;
        this.threshold = threshold;
    }

    @Override
    public int calculateFee(int amount) {
        if(amount >= threshold) {
            return fee;
        }
        return 0;
    }
}
