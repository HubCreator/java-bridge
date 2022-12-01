package bridge.domain;

import bridge.enums.UpDown;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<UpDown> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = mapBridge(bridge);
    }

    private List<UpDown> mapBridge(List<String> bridge) {
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
}
