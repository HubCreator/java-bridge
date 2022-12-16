package bridge.domain;

import bridge.enums.RetryQuit;
import bridge.enums.UpDown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertAll(
                () -> assertEquals(bridgeGame.move(UpDown.UP).toString(), "[ O ]\n[   ]"),
                () -> assertEquals(bridgeGame.move(UpDown.UP).toString(), "[ O | O ]\n[   |   ]"),
                () -> assertEquals(bridgeGame.move(UpDown.DOWN).toString(), "[ O | O |   ]\n[   |   | O ]")
        );
    }

    @DisplayName("중간에 실패")
    @Test
    void canNotReachedToTheEndTest() {
        assertAll(
                () -> assertEquals(bridgeGame.move(UpDown.UP).toString(), "[ O ]\n[   ]"),
                () -> assertEquals(bridgeGame.move(UpDown.DOWN).toString(), "[ O |   ]\n[   | X ]")
        );
    }

    @DisplayName("실패 후 재시작")
    @Test
    void retryTest() {
        assertAll(
                () -> assertEquals(bridgeGame.move(UpDown.UP).toString(), "[ O ]\n[   ]"),
                () -> assertEquals(bridgeGame.move(UpDown.DOWN).toString(), "[ O |   ]\n[   | X ]")
        );
        bridgeGame.retry(RetryQuit.RETRY);
        assertThat(bridgeGame.move(UpDown.UP).toString()).isEqualTo("[ O ]\n[   ]");
    }
}