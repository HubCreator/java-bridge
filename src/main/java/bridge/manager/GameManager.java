package bridge.manager;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatusMap;
import bridge.enums.RetryQuit;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final BridgeGame bridgeGame;

    public GameManager(BridgeMaker bridgeMaker) {
        int bridgeSize = InputView.readBridgeSize();
        Bridge bridge = Bridge.create(bridgeMaker.makeBridge(bridgeSize));
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void run() {
        while (goForward() && retryOrNot()) {
            //
        }
        OutputView.printResult(bridgeGame);
    }

    private boolean goForward() {
        while (bridgeGame.canGoForward()) {
            GameStatusMap gameStatusMap = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(gameStatusMap);
            if (bridgeGame.isOver()) {
                return false;
            }
        }
        return true;
    }

    private boolean retryOrNot() {
        RetryQuit command = InputView.readGameCommand();
        if (RetryQuit.RETRY.isEqualTo(command)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
