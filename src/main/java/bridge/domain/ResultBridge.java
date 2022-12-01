package bridge.domain;

import bridge.enums.ResultFlag;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultBridge {
    private List<ResultFlag> resultBridge;

    private ResultBridge(List<ResultFlag> resultBridge) {
        this.resultBridge = resultBridge;
    }

    public static ResultBridge create() {
        return new ResultBridge(new ArrayList<>());
    }

    public void addOFlag() {
        resultBridge.add(ResultFlag.O_FLAG);
    }

    public void addXFlag() {
        resultBridge.add(ResultFlag.X_FLAG);
    }

    public void addEmptyFlag() {
        resultBridge.add(ResultFlag.EMPTY_FLAG);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (ResultFlag resultFlag : resultBridge) {
            stringJoiner.add(resultFlag.getValue());
        }
        return stringJoiner.toString();
    }
}
