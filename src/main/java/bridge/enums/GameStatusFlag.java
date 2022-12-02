package bridge.enums;

public enum GameStatusFlag {
    O_FLAG("O"), X_FLAG("X"), EMPTY_FLAG(" ");

    private final String value;

    GameStatusFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
