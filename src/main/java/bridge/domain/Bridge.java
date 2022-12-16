package bridge.domain;

import bridge.enums.UpDown;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<UpDown> bridge;

    private Bridge() {
    }

    private Bridge(List<UpDown> list) {
        this.bridge = list;
    }

    public static Bridge create(List<String> bridge) {
        return new Bridge(mapBridge(bridge));
    }

    private static List<UpDown> mapBridge(List<String> bridge) {
        return bridge.stream()
                .map(UpDown::map)
                .collect(Collectors.toList());
    }

    private UpDown getByIndex(Position position) {
        return bridge.get(position.getPosition());
    }

    boolean isMatch(Position position, UpDown input) {
        UpDown answer = getByIndex(position);
        return answer.isEqualTo(input);
    }

    public boolean isSucceed(Position position) {
        return position.isSame(bridge.size() - 1);
    }

    boolean hasReachedToTheEnd(Position position) {
        return position.isSame(this.bridge.size() - 1);
    }
}
