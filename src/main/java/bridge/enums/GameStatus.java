package bridge.enums;

public enum GameStatus {
    MAKE_BRIDGE,
    GAME_PLAY,
    GAME_OVER,
    GAME_EXIT,
    APPLICATION_EXIT;

    public static GameStatus getNextStatus(boolean canGoForward, boolean isOver) {
        if (isOver) {
            return GAME_EXIT;
        }
        if (!canGoForward) {
            return GameStatus.GAME_OVER;
        }
        return GameStatus.GAME_PLAY;
    }

    public boolean playable() {
        return this != GameStatus.APPLICATION_EXIT;
    }

    public static GameStatus retryOrNot(boolean isRetry) {
        if (isRetry) {
            return GameStatus.GAME_PLAY;
        }
        return GameStatus.GAME_EXIT;
    }
}