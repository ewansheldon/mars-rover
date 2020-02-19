package ewansheldon.kata.mars_rover;

public class Orientation {
    private String direction;

    public Orientation() {
        this.direction = "N";
    }

    public String getDirection() {
        return direction;
    }

    public void turnRight() {
        direction = nextPositions().right;
    }

    public void turnLeft() {
        direction = nextPositions().left;
    }

    private NextPosition nextPositions() {
        return NextPosition.valueOf(direction);
    }
}
