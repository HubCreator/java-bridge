package bridge.domain;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;
import bridge.enums.RetryQuit;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answer;
    private final Position position;
    private final GameStatusMap gameStatusMap;
    private final TryCount tryCount;

    public BridgeGame(Bridge bridge) {
        this.answer = bridge;
        this.position = new Position();
        this.gameStatusMap = new GameStatusMap();
        this.tryCount = new TryCount();
    }

    public BridgeGame(ReadBridgeSizeDto inputDto, BridgeMaker bridgeMaker) {
        List<String> bridge = bridgeMaker.makeBridge(inputDto.getSize());

        this.answer = Bridge.create(bridge);
        this.position = new Position();
        this.gameStatusMap = new GameStatusMap();
        this.tryCount = new TryCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param dto
     */
    public PrintMapDto move(ReadMovingDto dto) {
        position.increase();
        if (answer.isMatch(position, dto.getUpDown())) {
            gameStatusMap.correctUpdate(dto.getUpDown());
            return new PrintMapDto(gameStatusMap);
        }
        gameStatusMap.failedUpdate(dto.getUpDown());
        position.fail();
        return new PrintMapDto(gameStatusMap);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(ReadGameCommandDto dto) {
        if (RetryQuit.RETRY == dto.getRetryQuit()) {
            tryCount.increase();
            position.clear();
            gameStatusMap.clear();
            return true;
        }
        return false;
    }

    public boolean isOver() {
        return answer.hasReachedToTheEnd(position);
    }

    public boolean canGoForward() {
        return !position.isFail() && !answer.hasReachedToTheEnd(position);
    }

    public PrintResultDto getResult() {
        return new PrintResultDto(gameStatusMap, answer, position, tryCount);
    }
}
