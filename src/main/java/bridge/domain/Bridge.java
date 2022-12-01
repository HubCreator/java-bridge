package bridge.domain;

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
            if (UpDown.UP.isMatchFlag(input)) {
                result.add(UpDown.UP);
                continue;
            }
            result.add(UpDown.DOWN);
        }
        return result;
    }

    public boolean isMatch(Position position, UpDown input) {
        UpDown answer = getByIndex(position);
        return answer == input;
    }

    private UpDown getByIndex(Position position) {
        return bridge.get(position.getPosition());
    }

    public int size() {
        return this.bridge.size();
    }
}
