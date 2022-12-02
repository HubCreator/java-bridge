package bridge.domain;

import bridge.enums.UpDown;

public class GameStatusMap {
    private ResultBridge upBridge;
    private ResultBridge downBridge;

    public GameStatusMap() {
        this.upBridge = ResultBridge.create();
        this.downBridge = ResultBridge.create();
    }

    public void correctUpdate(UpDown input) {
        if (UpDown.UP == input) {
            upBridge.addOFlag();
            downBridge.addEmptyFlag();
            return;
        }
        downBridge.addOFlag();
        upBridge.addEmptyFlag();
    }

    public void failedUpdate(UpDown input) {
        if (UpDown.UP == input) {
            upBridge.addXFlag();
            downBridge.addEmptyFlag();
            return;
        }
        downBridge.addXFlag();
        upBridge.addEmptyFlag();
    }

    public void clear() {
        this.upBridge = ResultBridge.create();
        this.downBridge = ResultBridge.create();
    }

    @Override
    public String toString() {
        return upBridge.toString() + "\n" + downBridge.toString();
    }
}
