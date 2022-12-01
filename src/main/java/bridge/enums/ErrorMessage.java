package bridge.enums;

public enum ErrorMessage {
    INVALID_INPUT_DIGIT("입력 범위 내의 숫자를 입력하셔야 합니다."),
    INVALID_INPUT_RANGE("3에서 20 사이의 값을 입력하셔야 합니다.");

    private static final String errorHead = "[ERROR] ";
    private static final String errorTail = " 다시 입력해주세요.";

    private final String value;

    ErrorMessage(String value) {
        this.value = errorHead + value + errorTail;
    }

    public String getValue() {
        return value;
    }
}
