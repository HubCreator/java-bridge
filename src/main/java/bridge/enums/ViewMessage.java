package bridge.enums;

public enum ViewMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_RESULT_MESSAGE("최종 게임 결과"),
    OUTPUT_IS_SUCCEED("게임 성공 여부: {0}"),
    OUTPUT_TRY_COUNT("총 시도한 횟수: {0}");


    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
