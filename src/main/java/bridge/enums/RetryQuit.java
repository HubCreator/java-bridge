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

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }

    public String getFlag() {
        return flag;
    }
}
