package bridge.dto.input;

import bridge.enums.UpDown;

public class ReadMovingDto {
    private final UpDown upDown;

    public ReadMovingDto(UpDown upDown) {
        this.upDown = upDown;
    }

    public UpDown getUpDown() {
        return upDown;
    }
}
