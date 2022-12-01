package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultBridge {
    private List<String> resultBridge;

    private ResultBridge(List<String> resultBridge) {
        this.resultBridge = resultBridge;
    }

    public static ResultBridge create(int size) {
        List<String> resultBridge = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            resultBridge.add(" ");
        }
        return new ResultBridge(resultBridge);
    }

    public void correctUpdate(Position position) {
        resultBridge.set(position.getPosition(), "O");
    }

    public void failUpdate(Position position) {
        resultBridge.set(position.getPosition(), "X");
    }

    public String getByIndex(int index) {
        return resultBridge.get(index);
    }
}
