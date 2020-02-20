package ewansheldon.kata.mars_rover;

public class TurnRight implements Command {
    private Orientation orientation;

    public TurnRight(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void execute() {
        orientation.turnRight();
    }
}
