package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeMakerTest {

    @DisplayName("입력받은 숫자 길이의 다리를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void test(int value) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(value);
        assertThat(strings.size()).isEqualTo(value);
        assertThat(strings).containsAnyOf("U", "D");
    }
}