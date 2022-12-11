package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatusMap;
import bridge.dto.input.ReadBridgeSizeDto;
import bridge.enums.GameStatus;
import bridge.view.IOViewResolver;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {
    private final IOViewResolver ioViewResolver;
    private final Map<GameStatus, Supplier<GameStatus>> statusMap;
    private BridgeGame bridgeGame;

    public GameController(IOViewResolver ioViewResolver) {
        this.ioViewResolver = ioViewResolver;
        statusMap = new EnumMap<>(GameStatus.class);
        initGameStatusMap();
    }

    private void initGameStatusMap() {
        statusMap.put(GameStatus.MAKE_BRIDGE, this::makeBridge);
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

    private GameStatus makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        ReadBridgeSizeDto inputDto = ioViewResolver.inputViewResolve(ReadBridgeSizeDto.class);
        bridgeGame = new BridgeGame(inputDto, bridgeMaker);
        return GameStatus.GAME_PLAY;
    }

    private GameStatus gamePlay() {
        GameStatusMap gameStatusMap = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(gameStatusMap);
        return GameStatus.getNextStatus(bridgeGame.canGoForward(), bridgeGame.isOver());
    }

    private GameStatus gameOver() {
        boolean isRetry = bridgeGame.retry(InputView.readGameCommand());
        return GameStatus.retryOrNot(isRetry);
    }

    private GameStatus gameExit() {
        OutputView.printResult(bridgeGame);
        return GameStatus.APPLICATION_EXIT;
    }
}