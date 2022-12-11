package bridge;

import bridge.controller.GameController;
import bridge.enums.GameStatus;

public final class GameManager {

    private static final GameStatus INITIAL_STATUS = GameStatus.MAKE_BRIDGE;

    private GameManager() {

    }

    public static void run() {
        GameController controller = new GameController();
        GameStatus status = INITIAL_STATUS;
        while (status.playable()) {
            status = controller.process(status);
        }
    }
}