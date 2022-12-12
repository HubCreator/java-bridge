package bridge.domain;

public class TryCount {
    private static final int INITIAL_VALUE = 1;
    private int tryCount;

    public TryCount() {
        this.tryCount = INITIAL_VALUE;
    }

    void increase() {
        tryCount++;
    }

    int getTryCount() {
        return tryCount;
    }
}
