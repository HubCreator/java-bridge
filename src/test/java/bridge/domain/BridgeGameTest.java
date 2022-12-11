package bridge.domain;

import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintMapDto;
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
        PrintMapDto dto1 = bridgeGame.move(new ReadMovingDto(UpDown.UP));
        assertThat(dto1.getGameStatusMap().toString()).isEqualTo("[ O ]\n[   ]");

        PrintMapDto dto2 = bridgeGame.move(new ReadMovingDto(UpDown.UP));
        assertThat(dto2.getGameStatusMap().toString()).isEqualTo("[ O | O ]\n[   |   ]");

        PrintMapDto dto3 = bridgeGame.move(new ReadMovingDto(UpDown.DOWN));
        assertThat(dto3.getGameStatusMap().toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
    }

    @DisplayName("중간에 실패")
    @Test
    void canNotReachedToTheEndTest() {
        PrintMapDto dto1 = bridgeGame.move(new ReadMovingDto(UpDown.UP));
        assertThat(dto1.getGameStatusMap().toString()).isEqualTo("[ O ]\n[   ]");

        PrintMapDto dto2 = bridgeGame.move(new ReadMovingDto(UpDown.DOWN));
        assertThat(dto2.getGameStatusMap().toString()).isEqualTo("[ O |   ]\n[   | X ]");
    }

    @DisplayName("실패 후 재시작")
    @Test
    void retryTest() {
        PrintMapDto dto1 = bridgeGame.move(new ReadMovingDto(UpDown.UP));
        assertThat(dto1.getGameStatusMap().toString()).isEqualTo("[ O ]\n[   ]");

        PrintMapDto dto2 = bridgeGame.move(new ReadMovingDto(UpDown.DOWN));
        assertThat(dto2.getGameStatusMap().toString()).isEqualTo("[ O |   ]\n[   | X ]");

        bridgeGame.retry(new ReadGameCommandDto(RetryQuit.RETRY));
        PrintMapDto dto3 = bridgeGame.move(new ReadMovingDto(UpDown.UP));
        assertThat(dto3.getGameStatusMap().toString()).isEqualTo("[ O ]\n[   ]");
    }
}