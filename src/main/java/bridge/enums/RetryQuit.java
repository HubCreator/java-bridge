package bridge.enums;

public enum RetryQuit {
    RETRY("R"), QUIT("Q");

    private final String flag;

    RetryQuit(String flag) {
        this.flag = flag;
    }

    public boolean isEqualTo(RetryQuit input) {
        return this == input;
    }

    public static RetryQuit map(String flag) {
        validate(flag);
        if (RETRY.flag.equals(flag)) {
            return RETRY;
        }
        return QUIT;
    }

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }

    private static void validate(String flag) {
        if (!RETRY.isMatchFlag(flag) && !QUIT.isMatchFlag(flag)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_RETRY_QUIT.getValue());
        }
    }

    public String getFlag() {
        return flag;
    }
}
