package bridge.domain;

import bridge.enums.UpDown;

import java.text.MessageFormat;

public class GameStatusMap {
    private static final String messageFormat = "{0}\n{1}";

    private final ResultBridge upBridge;
    private final ResultBridge downBridge;

    public GameStatusMap() {
        this.upBridge = new ResultBridge();
        this.downBridge = new ResultBridge();
    }

    void correctUpdate(UpDown input) {
        if (UpDown.UP.isEqualTo(input)) {
            upBridge.addOFlag();
            downBridge.addEmptyFlag();
            return;
        }
        downBridge.addOFlag();
        upBridge.addEmptyFlag();
    }

    void failedUpdate(UpDown input) {
        if (UpDown.UP.isEqualTo(input)) {
            upBridge.addXFlag();
            downBridge.addEmptyFlag();
            return;
        }
        downBridge.addXFlag();
        upBridge.addEmptyFlag();
    }

    void clear() {
        upBridge.clear();
        downBridge.clear();
    }

    @Override
    public String toString() {
        return MessageFormat.format(messageFormat, upBridge.toString(), downBridge.toString());
    }
}
