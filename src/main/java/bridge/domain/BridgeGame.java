package bridge.domain;

import bridge.enums.UpDown;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answer;
    private final Position position;
    private final Result result;
    private TryCount tryCount;

    public BridgeGame(Bridge bridge) {
        this.answer = bridge;
        this.position = new Position();
        this.result = new Result();
        this.tryCount = new TryCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param input
     */
    public Result move(UpDown input) {
        position.increase();
        if (answer.isMatch(position, input)) {
            result.correctUpdate(input);
            return result;
        }
        result.failedUpdate(input);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount.increase();
        position.clear();
        result.clear();
    }

    public boolean canGoForward() {
        return false;
    }
}
