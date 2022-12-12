package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultBridge {

    private final List<GameStatusFlag> resultBridge = new ArrayList<>();

    public  void clear() {
        resultBridge.clear();
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
        StringJoiner stringJoiner = new StringJoiner(
                Format.DELIMITER.value, Format.PREFIX.value, Format.SUFFIX.value);

        for (GameStatusFlag gameStatusFlag : resultBridge) {
            stringJoiner.add(gameStatusFlag.value);
        }
        return stringJoiner.toString();
    }

    private enum GameStatusFlag {
        O_FLAG("O"), X_FLAG("X"), EMPTY_FLAG(" ");

        private final String value;

        GameStatusFlag(String value) {
            this.value = value;
        }
    }

    private enum Format {
        PREFIX("[ "),
        SUFFIX(" ]"),
        DELIMITER(" | ");

        private final String value;

        Format(String value) {
            this.value = value;
        }
    }
}
