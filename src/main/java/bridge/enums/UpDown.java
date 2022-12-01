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
        if (value == UP.value) {
            return UP;
        }
        return DOWN;
    }

    public boolean isMatchFlag(String input) {
        return this.flag.equals(input);
    }

    public String getFlag() {
        return flag;
    }

    public int getValue() {
        return value;
    }
}
