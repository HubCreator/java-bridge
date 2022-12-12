package bridge.view;

import bridge.enums.RetryQuit;
import bridge.enums.UpDown;
import bridge.enums.ViewMessage;
import bridge.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printMessage(ViewMessage.START_MESSAGE, ViewMessage.INPUT_BRIDGE_LENGTH);
        while (true) {
            try {
                return ValidationUtil.validate(Console.readLine());
            } catch (IllegalArgumentException exception) {
                printMessage(exception);
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static UpDown readMoving() {
        printMessage(ViewMessage.INPUT_UP_OR_DOWN);
        while (true) {
            try {
                return ValidationUtil.isValidUpDown(Console.readLine());
            } catch (IllegalArgumentException exception) {
                printMessage(exception);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static RetryQuit readGameCommand() {
        printMessage(ViewMessage.INPUT_RETRY_OR_QUIT);
        while (true) {
            try {
                return ValidationUtil.isValidRetryQuit(Console.readLine());
            } catch (IllegalArgumentException exception) {
                printMessage(exception);
            }
        }
    }

    private static void printMessage(ViewMessage message) {
        System.out.println(message.getValue());
    }

    private static void printMessage(ViewMessage... messages) {
        for (ViewMessage message : messages) {
            printMessage(message);
        }
    }

    private static void printMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
