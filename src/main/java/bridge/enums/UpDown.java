package bridge.enums;

public enum UpDown {
    UP("U", 1), DOWN("D", 0);

    private final String flag;
    private final int value;

    UpDown(String flag, int value) {
        this.flag = flag;
        this.value = value;
    }

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }
}
