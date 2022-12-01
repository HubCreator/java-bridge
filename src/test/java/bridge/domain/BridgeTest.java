package bridge.domain;

import bridge.enums.UpDown;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("정상적인 값을 가져올 수 있다.")
    @Test
    void case1() {
        Bridge bridge = Bridge.create(Arrays.asList("U", "U", "D"));
        assertThat(bridge.isMatch(new Position(0), UpDown.UP)).isEqualTo(true);
        assertThat(bridge.isMatch(new Position(1), UpDown.UP)).isEqualTo(true);
        assertThat(bridge.isMatch(new Position(2), UpDown.DOWN)).isEqualTo(true);
    }
}