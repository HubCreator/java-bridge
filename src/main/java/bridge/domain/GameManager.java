package bridge.domain;

import bridge.enums.Key;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {
    private final List<String> bridge;
    private final BridgeGame bridgeGame;

    public GameManager(BridgeMaker bridgeMaker) {
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    protected GameManager(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        boolean status;
        do {
            status = moveForward();
        } while (status && retryOrNot());

        OutputView.printResult(bridgeGame);
    }

    private boolean moveForward() {
        while (bridgeGame.canGoForward()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return bridgeGame.isFail(); // 다리의 끝까지 도달하지 못했는가?
    }

    private boolean retryOrNot() {
        if (Key.matchQuit(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}
