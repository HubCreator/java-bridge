package bridge.domain;

import bridge.enums.GameStatusFlag;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultBridge {
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String DELIMITER = " | ";

    private final List<GameStatusFlag> resultBridge;

    private ResultBridge(List<GameStatusFlag> resultBridge) {
        this.resultBridge = resultBridge;
    }

    public static ResultBridge create() {
        return new ResultBridge(new ArrayList<>());
    }

     void addOFlag() {
        resultBridge.add(GameStatusFlag.O_FLAG);
    }

     void addXFlag() {
        resultBridge.add(GameStatusFlag.X_FLAG);
    }

     void addEmptyFlag() {
        resultBridge.add(GameStatusFlag.EMPTY_FLAG);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (GameStatusFlag gameStatusFlag : resultBridge) {
            stringJoiner.add(gameStatusFlag.getValue());
        }
        return stringJoiner.toString();
    }
}
