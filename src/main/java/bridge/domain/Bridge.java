package bridge.domain;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.enums.UpDown;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<UpDown> bridge;

    private Bridge() {
    }

    private Bridge(List<UpDown> list) {
        this.bridge = list;
    }

    public static Bridge create(List<String> bridge) {
        List<UpDown> list = mapBridge(bridge);
        return new Bridge(list);
    }

    private static List<UpDown> mapBridge(List<String> bridge) {
        List<UpDown> result = new ArrayList<>();
        for (String input : bridge) {
            result.add(UpDown.map(input));
        }
        return result;
    }

    private UpDown getByIndex(Position position) {
        return bridge.get(position.getPosition());
    }

    boolean isMatch(Position position, UpDown input) {
        UpDown answer = getByIndex(position);
        return answer.isEqualTo(input);
    }

    boolean isSucceed(Position position) {
        return position.isSame(bridge.size() - 1);
    }

    boolean hasReachedToTheEnd(Position position) {
        return position.isSame(this.bridge.size() - 1);
    }
}
