package bridge.domain;

public class TryCount {
    private static final int INITIAL_VALUE = 1;
    private int tryCount;

    public TryCount() {
        this.tryCount = INITIAL_VALUE;
    }

    public void increase() {
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }
}
