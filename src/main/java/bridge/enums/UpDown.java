package bridge.enums;

public enum UpDown {
    UP("U", 1), DOWN("D", 0);

    private final String flag;
    private final int value;

    UpDown(String flag, int value) {
        this.flag = flag;
        this.value = value;
    }

    public static UpDown map(int value) {
        if (UP.value == value) {
            return UP;
        }
        return DOWN;
    }

    public static UpDown map(String flag) {
        validate(flag);

        if (UP.flag.equals(flag)) {
            return UP;
        }
        return DOWN;
    }

    private static void validate(String flag) {
        if (!UP.isMatchFlag(flag) && !DOWN.isMatchFlag(flag)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_UP_DOWN.getValue());
        }
    }

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }

    public boolean isEqualTo(UpDown input) {
        return this == input;
    }

    public String getFlag() {
        return flag;
    }

    public int getValue() {
        return value;
    }
}
