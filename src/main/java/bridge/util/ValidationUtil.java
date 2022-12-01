package bridge.util;

import bridge.enums.ErrorMessage;

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
}
