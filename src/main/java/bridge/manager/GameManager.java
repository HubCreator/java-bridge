package bridge.manager;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Result;
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
        do {
            Result result = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(result);
        } while (bridgeGame.canGoForward());
    }
}
