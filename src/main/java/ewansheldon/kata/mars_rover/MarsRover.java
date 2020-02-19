package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    public static final String RESPONSE_FORMAT = "%s:%s:%s";
    public static final String OBSTACLE_FLAG = "O:";
    private Position position;
    private String commands;

    public MarsRover(Position position) {
        this.position = position;
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

    private String currentDirection() {
        return position.currentDirection();
    }

    private String formattedPosition() {
        return format(RESPONSE_FORMAT, coordinates()[0], coordinates()[1], currentDirection());
    }

    private int[] coordinates() {
        return position.getCoordinates();
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + formattedPosition();
    }
}