package bridge.dto.output;

import bridge.domain.Bridge;
import bridge.domain.GameStatusMap;
import bridge.domain.Position;
import bridge.domain.TryCount;
import bridge.enums.ViewMessage;

import java.text.MessageFormat;

public class PrintResultDto {
    private final GameStatusMap gameStatusMap;
    private final Bridge answer;
    private final Position position;
    private final TryCount tryCount;

    public PrintResultDto(GameStatusMap gameStatusMap, Bridge answer, Position position, TryCount tryCount) {
        this.gameStatusMap = gameStatusMap;
        this.answer = answer;
        this.position = position;
        this.tryCount = tryCount;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder(ViewMessage.OUTPUT_RESULT_MESSAGE.getValue());
        result.append(gameStatusMap);
        if (answer.isSucceed(position)) {
            result.append(MessageFormat.format(ViewMessage.OUTPUT_IS_SUCCEED.getValue(), ViewMessage.SUCCEED.getValue(), tryCount.getTryCount()));
            return result.toString();
        }
        result.append(MessageFormat.format(ViewMessage.OUTPUT_IS_SUCCEED.getValue(), ViewMessage.FAILED.getValue(), tryCount.getTryCount()));
        return result.toString();
    }
}
