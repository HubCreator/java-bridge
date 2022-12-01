package bridge.util;

import bridge.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidationUtilTest {

    @DisplayName("다리의 길이를 입력 받을 때엔")
    @Nested
    class DescribeBridgeInputTest {

        @DisplayName("만약 유효한 범위의 입력값이 들어오면")
        @Nested
        class ContextValidInputTest {

            @DisplayName("통과한다.")
            @ParameterizedTest
            @ValueSource(strings = {"3", "20"})
            void it_returns_bridge(String value) {
                assertThatCode(() -> ValidationUtil.isValidInput(value))
                        .doesNotThrowAnyException();
            }
        }

        @DisplayName("만약 유효하지 않은")
        @Nested
        class ContextInValidInputTest {

            @DisplayName("범위를 초과한 경우 예외를 발생시킨다.")
            @ParameterizedTest
            @ValueSource(strings = {"2", "21", "-1"})
            void it_returns_exception1(String value) {
                assertThatThrownBy(() -> ValidationUtil.isValidInput(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_INPUT_RANGE.getValue());
            }

            @DisplayName("입력 숫자 범위를 초과한 입력이 들어오면 예외를 발생시킨다.")
            @Test
            void it_returns_exception2() {
                assertThatThrownBy(() -> ValidationUtil.isValidInput("999999999999999999999999999999999999999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_INPUT_DIGIT.getValue());
            }

            @DisplayName("특수 문자 혹은 빈 문자열이 들어오면 예외를 발생시킨다.")
            @ParameterizedTest
            @ValueSource(strings = {"*", "", "!"})
            void it_returns_exception3(String value) {
                assertThatThrownBy(() -> ValidationUtil.isValidInput(value))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_INPUT_DIGIT.getValue());
            }
        }
    }

}