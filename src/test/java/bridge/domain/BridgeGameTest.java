package bridge.domain;

import bridge.enums.UpDown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        Bridge answer = Bridge.create(Arrays.asList("U", "U", "D"));
        bridgeGame = new BridgeGame(answer);
    }

    @DisplayName("끝까지 도달")
    @Test
    void case1() {
        Result result1 = bridgeGame.move(UpDown.UP);
        assertThat(result1.toString()).isEqualTo("[ O ]\n[   ]");

        Result result2 = bridgeGame.move(UpDown.UP);
        assertThat(result2.toString()).isEqualTo("[ O | O ]\n[   |   ]");

        Result result3 = bridgeGame.move(UpDown.DOWN);
        assertThat(result3.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
    }

}