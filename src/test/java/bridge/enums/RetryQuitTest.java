package bridge.enums;

import bridge.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RetryQuitTest {

    @DisplayName("Retry인지 Quit인지 확인한다.")
    @Nested
    class isValidRetryQuitTest {

        @DisplayName("R혹은 Q가 입력되면 통과한다.")
        @ParameterizedTest
        @ValueSource(strings = {"R", "Q"})
        void case1(String value) {
            assertThatCode(() -> ValidationUtil.isValidRetryQuit(value))
                    .doesNotThrowAnyException();
        }

        @DisplayName("이외의 입력은 에러를 발생시킨다..")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D", "!", "123", ""})
        void case2(String value) {
            assertThatThrownBy(() -> ValidationUtil.isValidRetryQuit(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_RETRY_QUIT.getValue());
        }
    }

}