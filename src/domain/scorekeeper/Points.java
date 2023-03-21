package domain.scorekeeper;

public enum Points {
    LIMIT(1000), ONE_POINT(1), TWO_POINTS(2), THREE_POINTS(3);
    private int value;

    Points(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}