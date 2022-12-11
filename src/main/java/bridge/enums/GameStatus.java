package bridge.enums;

public enum GameStatus {
    MAKE_BRIDGE,
    GAME_PLAY,
    GAME_OVER,
    GAME_EXIT,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != GameStatus.APPLICATION_EXIT;
    }
}
