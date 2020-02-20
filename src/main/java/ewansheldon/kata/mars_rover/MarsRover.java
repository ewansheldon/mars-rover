package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    public static final String RESPONSE_FORMAT = "%s:%s:%s";
    public static final String OBSTACLE_FLAG = "O:";
    private String commands;
    private Position position;
    private CommandControl commandControl;

    public MarsRover(Position position, CommandControl commandControl) {
        this.position = position;
        this.commandControl = commandControl;
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
            commandControl.execute(commands.charAt(i));
        }
    }

    private String formattedPosition() {
        return format(RESPONSE_FORMAT, coordinates()[0], coordinates()[1], currentDirection());
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + formattedPosition();
    }

    private int[] coordinates() {
        return position.getCoordinates();
    }

    private String currentDirection() {
        return position.currentDirection();
    }
}