package ewansheldon.kata.mars_rover;

public class TurnLeft implements Command {
    private Orientation orientation;

    public TurnLeft(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void execute() {
        orientation.turnLeft();
    }
}
