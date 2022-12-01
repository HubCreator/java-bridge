package bridge.util;

import bridge.enums.ConstVariable;
import bridge.enums.ErrorMessage;
import bridge.enums.RetryQuit;
import bridge.enums.UpDown;

public class ValidationUtil {
    public static int validate(String input) {
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
        if (!UpDown.UP.isMatchFlag(input) && !UpDown.DOWN.isMatchFlag(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_UP_DOWN.getValue());
        }
        if (UpDown.UP.isMatchFlag(input)) {
            return UpDown.UP;
        }
        return UpDown.DOWN;
    }

    public static RetryQuit isValidRetryQuit(String input) {
        if (!RetryQuit.RETRY.isMatchFlag(input) && !RetryQuit.QUIT.isMatchFlag(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_RETRY_QUIT.getValue());
        }
        if (RetryQuit.RETRY.isMatchFlag(input)) {
            return RetryQuit.RETRY;
        }
        return RetryQuit.QUIT;
    }
}
