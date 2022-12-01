package bridge.enums;

public enum ConstVariable {
    MIN(3), MAX(20);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isLowerThan(int input) {
        return this.value > input;
    }

    public boolean isGreaterThan(int input) {
        return this.value < input;
    }
}
