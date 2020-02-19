package ewansheldon.kata.mars_rover;

public class CommandControl {
    private Position position;

    public CommandControl(Position position) {
        this.position = position;
    }

    public void execute(char command) throws ObstacleEncounteredException {
        if (command == 'M') position.move();
        if (command == 'R') position.turnRight();
        if (command == 'L') position.turnLeft();
    }

    public String currentDirection() {
        return position.currentDirection();
    }

    public int[] getCoordinates() {
        return position.getCoordinates();
    }
}
