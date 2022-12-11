package bridge.enums;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UpDownTest {

    @DisplayName("UP 혹은 DOWN인지 확인한다.")
    @Nested
    class isValidUpDownTest {

        @DisplayName("U혹은 D가 입력되면 통과한다.")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        void case1(String value) {
            assertThatCode(() -> InputView.isValidUpDown(value))
                    .doesNotThrowAnyException();
        }

        @DisplayName("이외의 입력은 에러를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"R", "Q", "!", "123", ""})
        void case2(String value) {
            assertThatThrownBy(() -> InputView.isValidUpDown(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INPUT_UP_DOWN.getValue());
        }
    }
}