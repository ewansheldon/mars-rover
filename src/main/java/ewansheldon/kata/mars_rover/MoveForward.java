package ewansheldon.kata.mars_rover;

public class MoveForward implements Command {
    private Position position;

    public MoveForward(Position position) {
        this.position = position;
    }

    @Override
    public void execute() throws ObstacleEncounteredException {
        position.move();
    }
}
