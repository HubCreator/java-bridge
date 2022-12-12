package bridge.enums;

public enum ViewMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", UpDown.UP.getFlag(), UpDown.DOWN.getFlag()),
    INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", RetryQuit.RETRY.getFlag(), RetryQuit.QUIT.getFlag()),
    OUTPUT_RESULT_MESSAGE("\n최종 게임 결과\n"),
    OUTPUT_IS_SUCCEED("\n게임 성공 여부: {0}\n총 시도한 횟수: {1}"),
    SUCCEED("성공"),
    FAILED("실패");


    private final String value;

    ViewMessage(String value, Object... replaces) {

        this.value = String.format(value, replaces);
    }

    public String getValue() {
        return value;
    }
}
