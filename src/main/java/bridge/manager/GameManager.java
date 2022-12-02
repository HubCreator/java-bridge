package bridge.manager;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatusMap;
import bridge.enums.RetryQuit;
import bridge.view.InputView;
import bridge.view.OutputView;


public class GameManager {

    private BridgeGame bridgeGame;

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
        }

        return false;
    }

    private boolean retryOrNot() {
        RetryQuit command = InputView.readGameCommand();
        if (command == RetryQuit.RETRY) {
            bridgeGame.retry();
            return true;
        }

        return false;
    }
}
