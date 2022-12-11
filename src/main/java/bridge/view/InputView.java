package bridge.view;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadMovingDto;
import bridge.enums.ConstVariable;
import bridge.enums.ErrorMessage;
import bridge.enums.RetryQuit;
import bridge.enums.UpDown;
import bridge.enums.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public ReadBridgeSizeDto readBridgeSize() {
        printMessage(ViewMessage.INPUT_BRIDGE_LENGTH);
        return new ReadBridgeSizeDto(validateBridgeLength(Console.readLine()));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public ReadMovingDto readMoving() {
        printMessage(ViewMessage.INPUT_UP_OR_DOWN);
        return new ReadMovingDto(isValidUpDown(Console.readLine()));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static RetryQuit readGameCommand() {
        printMessage(ViewMessage.INPUT_RETRY_OR_QUIT);
        return isValidRetryQuit(Console.readLine());
    }

    private static void printMessage(ViewMessage message) {
        System.out.println(message.getValue());
    }


    public static int validateBridgeLength(String input) {
        int value = isDigit(input);
        if (ConstVariable.MIN.isLowerThan(value) || ConstVariable.MAX.isGreaterThan(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_RANGE.getValue());
        }
        return value;
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_DIGIT.getValue(), e);
        }
    }

    public static UpDown isValidUpDown(String input) {
        return UpDown.map(input);
    }

    public static RetryQuit isValidRetryQuit(String input) {
        return RetryQuit.map(input);
    }


}
