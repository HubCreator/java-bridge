package bridge.dto.input;

import bridge.enums.RetryQuit;

public class ReadGameCommandDto {
    private final RetryQuit retryQuit;

    public ReadGameCommandDto(RetryQuit retryQuit) {
        this.retryQuit = retryQuit;
    }

    public RetryQuit getRetryQuit() {
        return retryQuit;
    }
}
