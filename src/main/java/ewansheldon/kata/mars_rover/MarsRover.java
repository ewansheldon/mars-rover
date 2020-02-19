package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    public static final String DEFAULT_DIRECTION = "N";
    public static final String RESPONSE_FORMAT = "%s:%s:%s";
    public static final String OBSTACLE_FLAG = "O:";
    private final int[] DEFAULT_COORDINATES = new int[]{0,0};
    private int[] coordinates;
    private String dir;
    private String commands;
    private Grid grid;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.coordinates = DEFAULT_COORDINATES;
        this.dir = DEFAULT_DIRECTION;
    }

    public String execute(String commands) {
        this.commands = commands;

        try {
            executeCommands();
            return formattedPosition();
        } catch (ObstacleEncounteredException e) {
            return obstacleResponse();
        }
    }

    private void executeCommands() throws ObstacleEncounteredException {
        for (int i = 0; i < commands.length(); i++) {
            executeCommand(commands.charAt(i));
        }
    }

    private void executeCommand(char command) throws ObstacleEncounteredException {
        switch (command) {
            case 'M':
                move();
                break;
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
        }
    }

    private void turnRight() {
        dir = getNextPosition().right;
    }

    private void turnLeft() {
        dir = getNextPosition().left;
    }

    private void move() throws ObstacleEncounteredException {
        int[] newCoordinates = addMovementVector(coordinates, getNextPosition().movementVector);

        try {
            coordinates = grid.confirmCoordinates(newCoordinates);
        } catch (Exception e) {
            throw new ObstacleEncounteredException();
        }
    }

    private int[] addMovementVector(int[] origin, int[] vector) {
        for (int i = 0; i < 2; i++) {
            origin[i] += vector[i];
        }

        return origin;
    }

    private NextPosition getNextPosition() {
        return NextPosition.valueOf(dir);
    }

    private String formattedPosition() {
        return format(RESPONSE_FORMAT, coordinates[0], coordinates[1], dir);
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + formattedPosition();
    }
}