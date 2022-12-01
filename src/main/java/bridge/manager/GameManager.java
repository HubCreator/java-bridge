package bridge.manager;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;


public class GameManager {

    private BridgeGame bridgeGame;

    public GameManager(BridgeMaker bridgeMaker) {
        int bridgeSize = InputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void run() {
        while (bridgeGame.canGoForward()) {
            bridgeGame.move(InputView.readMoving());

        }
    }
}
