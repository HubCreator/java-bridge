package bridge.domain;

import bridge.enums.UpDown;

import java.util.StringJoiner;

public class Result {
    private final ResultBridge upBridge;
    private final ResultBridge downBridge;
    private Position currentPosition;

    public Result(int size) {
        this.upBridge = ResultBridge.create(size);
        this.downBridge = ResultBridge.create(size);
    }

    public void correctUpdate(Position position, UpDown input) {
        currentPosition = position;
        if (UpDown.UP == input) {
            upBridge.correctUpdate(position);
            return;
        }
        downBridge.correctUpdate(position);
    }

    public void failedUpdate(Position position, UpDown input) {
        currentPosition = position;
        if (UpDown.UP == input) {
            upBridge.failUpdate(position);
            return;
        }
        downBridge.failUpdate(position);
    }

    @Override
    public String toString() {
        StringJoiner upJoiner = new StringJoiner(", ", "[", "]");
        StringJoiner downJoiner = new StringJoiner(", ", "[", "]");
        for (int index = 0; index < currentPosition.getPosition(); index++) {
            upJoiner.add(upBridge.getByIndex(index));
            downJoiner.add(upBridge.getByIndex(index));
        }
        return upJoiner + "\n" + downJoiner;
    }
}
