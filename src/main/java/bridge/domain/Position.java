package bridge.domain;

public class Position {
    public static final int INITIAL_INDEX = -1;
    public static final int FAILED_INDEX = -2;

    private int position;

    Position() {
        this.position = INITIAL_INDEX;
    }

    Position(int position) {
        this.position = position;
    }

    void increase() {
        ++position;
    }

    int getPosition() {
        return position;
    }

    void fail() {
        this.position = FAILED_INDEX;
    }

    boolean isFail() {
        return this.position == FAILED_INDEX;
    }

    boolean isSame(int value) {
        return position == value;
    }

    void clear() {
        this.position = INITIAL_INDEX;
    }
}
