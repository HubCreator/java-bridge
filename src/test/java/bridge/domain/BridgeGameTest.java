package bridge.domain;

import bridge.enums.RetryQuit;
import bridge.enums.UpDown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
        GameStatusMap gameStatusMap1 = bridgeGame.move(UpDown.UP);
        assertThat(gameStatusMap1.toString()).isEqualTo("[ O ]\n[   ]");

        GameStatusMap gameStatusMap2 = bridgeGame.move(UpDown.UP);
        assertThat(gameStatusMap2.toString()).isEqualTo("[ O | O ]\n[   |   ]");

        GameStatusMap gameStatusMap3 = bridgeGame.move(UpDown.DOWN);
        assertThat(gameStatusMap3.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
    }

    @DisplayName("중간에 실패")
    @Test
    void canNotReachedToTheEndTest() {
        GameStatusMap gameStatusMap1 = bridgeGame.move(UpDown.UP);
        assertThat(gameStatusMap1.toString()).isEqualTo("[ O ]\n[   ]");

        GameStatusMap gameStatusMap2 = bridgeGame.move(UpDown.DOWN);
        assertThat(gameStatusMap2.toString()).isEqualTo("[ O |   ]\n[   | X ]");
    }

    @DisplayName("실패 후 재시작")
    @Test
    void retryTest() {
        GameStatusMap gameStatusMap1 = bridgeGame.move(UpDown.UP);
        assertThat(gameStatusMap1.toString()).isEqualTo("[ O ]\n[   ]");

        GameStatusMap gameStatusMap2 = bridgeGame.move(UpDown.DOWN);
        assertThat(gameStatusMap2.toString()).isEqualTo("[ O |   ]\n[   | X ]");

        bridgeGame.retry(RetryQuit.RETRY);
        GameStatusMap gameStatusMap3 = bridgeGame.move(UpDown.UP);
        assertThat(gameStatusMap3.toString()).isEqualTo("[ O ]\n[   ]");
    }
}