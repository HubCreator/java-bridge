package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatusMap;
import bridge.enums.GameStatus;
import bridge.enums.ViewMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {
    private final Map<GameStatus, Supplier<GameStatus>> gameStatusMappings;
    private BridgeGame bridgeGame;

    public GameController() {
        System.out.println(ViewMessage.START_MESSAGE);
        gameStatusMappings = new EnumMap<>(GameStatus.class);
        initGameStatusMappings();
    }

    private void initGameStatusMappings() {
        gameStatusMappings.put(GameStatus.MAKE_BRIDGE, this::makeBridge);
        gameStatusMappings.put(GameStatus.GAME_PLAY, this::gamePlay);
        gameStatusMappings.put(GameStatus.GAME_OVER, this::gameOver);
        gameStatusMappings.put(GameStatus.GAME_EXIT, this::gameExit);
    }

    public GameStatus process(GameStatus gameStatus) {
        try {
            return gameStatusMappings.get(gameStatus).get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return gameStatus;
        }
    }

    private GameStatus makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        Bridge result = Bridge.create(bridge);
        bridgeGame = new BridgeGame(result);
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