package bridge.domain;

import bridge.enums.UpDown;

import java.text.MessageFormat;

public class GameStatusMap {
    private static final String messageFormat = "{0}\n{1}";

    private ResultBridge upBridge;
    private ResultBridge downBridge;

    public GameStatusMap() {
        clear();
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
        this.upBridge = ResultBridge.create();
        this.downBridge = ResultBridge.create();
    }

    @Override
    public String toString() {
        return MessageFormat.format(messageFormat, upBridge.toString(), downBridge.toString());
    }
}
