package bridge.util;

import bridge.enums.ErrorMessage;
import bridge.enums.RetryQuit;
import bridge.enums.UpDown;

public class ValidationUtil {
    public static void isValidInput(String input) {
        int value = isDigit(input);
        if (value < 3 || value > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_RANGE.getValue());
        }
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_DIGIT.getValue(), e);
        }
    }

    public static void isValidUpDown(String input) {
        if (!UpDown.UP.isMatchFlag(input) && !UpDown.DOWN.isMatchFlag(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_UPDOWN.getValue());
        }
    }

    public static void isValidRetryQuit(String value) {
        if (!RetryQuit.RETRY.isMatchFlag(value) && !RetryQuit.QUIt.isMatchFlag(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_RETRYQUIT.getValue());
        }
    }
}
