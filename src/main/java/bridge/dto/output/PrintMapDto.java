package bridge.dto.output;

import bridge.domain.GameStatusMap;

public class PrintMapDto {
    private final GameStatusMap gameStatusMap;

    public PrintMapDto(GameStatusMap gameStatusMap) {
        this.gameStatusMap = gameStatusMap;
    }

    public GameStatusMap getGameStatusMap() {
        return gameStatusMap;
    }
}
