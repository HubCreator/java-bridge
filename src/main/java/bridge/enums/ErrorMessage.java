package bridge.enums;

public enum ErrorMessage {
    INVALID_INPUT_DIGIT("입력 범위 내의 숫자를 입력하셔야 합니다."),
    INVALID_INPUT_RANGE("%d에서 %d 사이의 값을 입력하셔야 합니다.", ConstVariable.MIN.getValue(), ConstVariable.MAX.getValue()),
    INVALID_INPUT_UP_DOWN("%s혹은 %s를 입력하셔야 합니다.", UpDown.UP.getFlag(), UpDown.DOWN.getFlag()),
    INVALID_INPUT_RETRY_QUIT("%s혹은 %s를 입력하셔야 합니다.", RetryQuit.RETRY.getFlag(), RetryQuit.QUIT.getFlag());

    private static final String errorHead = "[ERROR] ";
    private static final String errorTail = " 다시 입력해주세요.";

    private final String value;

    ErrorMessage(String value, Object... replaces) {
        this.value = errorHead + String.format(value, replaces) + errorTail;
    }

    public String getValue() {
        return value;
    }
}
