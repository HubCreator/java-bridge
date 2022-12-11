package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeMaker;
import bridge.enums.GameStatus;
import bridge.view.IOViewResolver;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class GameManager {

    private static final GameStatus INITIAL_STATUS = GameStatus.MAKE_BRIDGE;

    private GameManager() {

    }

    public static void run() {
        GameStatus status = INITIAL_STATUS;
        IOViewResolver ioViewResolver = new IOViewResolver(InputView.getInstance(), OutputView.getInstance());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameController controller = new GameController(ioViewResolver, bridgeMaker);

        while (status.playable()) {
            status = controller.process(status);
        }
    }
}