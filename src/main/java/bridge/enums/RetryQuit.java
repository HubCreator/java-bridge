package bridge.enums;

public enum RetryQuit {
    RETRY("R"), QUIt("Q");

    private final String flag;

    RetryQuit(String flag) {
        this.flag = flag;
    }

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }

    public String getFlag() {
        return flag;
    }
}
