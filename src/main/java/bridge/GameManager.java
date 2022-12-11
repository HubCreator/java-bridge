package bridge;

import bridge.controller.GameController;
import bridge.enums.GameStatus;
import bridge.view.IOViewResolver;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class GameManager {

    private static final GameStatus INITIAL_STATUS = GameStatus.MAKE_BRIDGE;

    private GameManager() {

    }

    public static void run() {
        IOViewResolver ioViewResolver = new IOViewResolver(InputView.getInstance(), OutputView.getInstance());
        GameController controller = new GameController(ioViewResolver);
        GameStatus status = INITIAL_STATUS;
        while (status.playable()) {
            status = controller.process(status);
        }
    }
}