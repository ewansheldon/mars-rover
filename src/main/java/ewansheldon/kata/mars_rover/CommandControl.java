package ewansheldon.kata.mars_rover;

public class CommandControl {
    private Position position;

    public CommandControl(Position position) {
        this.position = position;
    }

    public void execute(char command) throws ObstacleEncounteredException {
        switch (command) {
            case 'M':
                position.move();
                break;
            case 'R':
                position.turnRight();
                break;
            case 'L':
                position.turnLeft();
                break;
        }
    }

    public String currentDirection() {
        return position.currentDirection();
    }

    public int[] getCoordinates() {
        return position.getCoordinates();
    }
}
