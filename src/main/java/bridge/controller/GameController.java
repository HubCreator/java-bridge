package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;
import bridge.enums.GameStatus;
import bridge.view.IOViewResolver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {
    private final IOViewResolver ioViewResolver;
    private final Map<GameStatus, Supplier<GameStatus>> statusMap;
    private BridgeGame bridgeGame;

    public GameController(IOViewResolver ioViewResolver, BridgeMaker bridgeMaker) {
        this.ioViewResolver = ioViewResolver;
        statusMap = new EnumMap<>(GameStatus.class);
        initGameStatusMap(bridgeMaker);
    }

    private void initGameStatusMap(BridgeMaker bridgeMaker) {
        statusMap.put(GameStatus.MAKE_BRIDGE, () -> makeBridge(bridgeMaker));
        statusMap.put(GameStatus.GAME_PLAY, this::gamePlay);
        statusMap.put(GameStatus.GAME_OVER, this::gameOver);
        statusMap.put(GameStatus.GAME_EXIT, this::gameExit);
    }

    public GameStatus process(GameStatus gameStatus) {
        try {
            return statusMap.get(gameStatus).get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return gameStatus;
        }
    }

    private GameStatus makeBridge(BridgeMaker bridgeMaker) {
        ReadBridgeSizeDto readBridgeSizeDto = ioViewResolver.inputViewResolve(ReadBridgeSizeDto.class);
        bridgeGame = new BridgeGame(readBridgeSizeDto, bridgeMaker);
        return GameStatus.GAME_PLAY;
    }

    private GameStatus gamePlay() {
        ReadMovingDto readMovingDto = ioViewResolver.inputViewResolve(ReadMovingDto.class);
        PrintMapDto printMapDto = bridgeGame.move(readMovingDto);
        ioViewResolver.outputViewResolve(printMapDto);
        return GameStatus.getNextStatus(bridgeGame.canGoForward(), bridgeGame.isOver());
    }

    private GameStatus gameOver() {
        ReadGameCommandDto readCommandDto = ioViewResolver.inputViewResolve(ReadGameCommandDto.class);
        boolean isRetry = bridgeGame.retry(readCommandDto);
        return GameStatus.retryOrNot(isRetry);
    }

    private GameStatus gameExit() {
        PrintResultDto printResultDto = bridgeGame.getResult();
        ioViewResolver.outputViewResolve(printResultDto);
        return GameStatus.APPLICATION_EXIT;
    }
}