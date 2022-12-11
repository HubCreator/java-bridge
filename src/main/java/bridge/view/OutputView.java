package bridge.view;

import bridge.domain.BridgeGame;
import bridge.dto.output.PrintMapDto;
import bridge.enums.ViewMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static class OutputViewSingletonHelper {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static bridge.view.OutputView getInstance() {
        return OutputViewSingletonHelper.OUTPUT_VIEW;
    }

    private OutputView() {
        System.out.println(ViewMessage.START_MESSAGE.getValue());
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param dto
     */
    public void printMap(PrintMapDto dto) {
        print(dto.getGameStatusMap().toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public static void printResult(BridgeGame bridgeGame) {
        print(bridgeGame.toString());
    }

    private static void print(String output) {
        System.out.println(output);
    }
}
