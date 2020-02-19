package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    public static final String RESPONSE_FORMAT = "%s:%s:%s";
    public static final String OBSTACLE_FLAG = "O:";
    private String commands;
    private CommandControl commandControl;

    public MarsRover(CommandControl commandControl) {
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

    private String currentDirection() {
        return commandControl.currentDirection();
    }

    private String formattedPosition() {
        return format(RESPONSE_FORMAT, coordinates()[0], coordinates()[1], currentDirection());
    }

    private int[] coordinates() {
        return commandControl.getCoordinates();
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + formattedPosition();
    }
}