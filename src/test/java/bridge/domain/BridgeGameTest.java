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
    void reachedToTheEndTest() {
        Result result1 = bridgeGame.move(UpDown.UP);
        assertThat(result1.toString()).isEqualTo("[ O ]\n[   ]");

        Result result2 = bridgeGame.move(UpDown.UP);
        assertThat(result2.toString()).isEqualTo("[ O | O ]\n[   |   ]");

        Result result3 = bridgeGame.move(UpDown.DOWN);
        assertThat(result3.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
    }

    @DisplayName("중간에 실패")
    @Test
    void canNotReachedToTheEndTest() {
        Result result1 = bridgeGame.move(UpDown.UP);
        assertThat(result1.toString()).isEqualTo("[ O ]\n[   ]");

        Result result2 = bridgeGame.move(UpDown.DOWN);
        assertThat(result2.toString()).isEqualTo("[ O |   ]\n[   | X ]");
    }

    @DisplayName("실패 후 재시작")
    @Test
    void retryTest() {
        Result result1 = bridgeGame.move(UpDown.UP);
        assertThat(result1.toString()).isEqualTo("[ O ]\n[   ]");

        Result result2 = bridgeGame.move(UpDown.DOWN);
        assertThat(result2.toString()).isEqualTo("[ O |   ]\n[   | X ]");

        bridgeGame.retry();
        Result result3 = bridgeGame.move(UpDown.UP);
        assertThat(result3.toString()).isEqualTo("[ O ]\n[   ]");
    }

}