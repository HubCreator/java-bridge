package bridge.domain;

import java.util.Objects;

public class Position {
    public static final int INITIAL_INDEX = -1;
    public static final int FAILED_INDEX = -2;

    private int position;

    public Position() {
        this.position = INITIAL_INDEX;
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        ++position;
    }

    public int getPosition() {
        return position;
    }

    public void clear() {
        this.position = INITIAL_INDEX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position target = (Position) o;
        return position == target.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
