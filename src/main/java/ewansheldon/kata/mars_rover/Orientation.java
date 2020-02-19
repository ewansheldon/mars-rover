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
        direction = NextPosition.valueOf(direction).right;
    }

    public void turnLeft() {
        direction = NextPosition.valueOf(direction).left;
    }
}
