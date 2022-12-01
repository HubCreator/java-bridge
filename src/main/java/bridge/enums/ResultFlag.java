package bridge.enums;

public enum ResultFlag {
    O_FLAG("O"), X_FLAG("X"), EMPTY_FLAG(" ");

    private final String value;

    ResultFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
