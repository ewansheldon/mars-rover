package ewansheldon.kata.mars_rover;

public class MarsRover {
    public static final String OBSTACLE_FLAG = "O:";
    private String input;
    private Position position;
    private CommandControl commandControl;

    public MarsRover(Position position, CommandControl commandControl) {
        this.position = position;
        this.commandControl = commandControl;
    }

    public String execute(String input) {
        this.input = input;

        try {
            executeCommands();
            return position.formattedPosition();
        } catch (ObstacleEncounteredException e) {
            return obstacleResponse();
        }
    }

    private void executeCommands() throws ObstacleEncounteredException {
        String[] commands = input.split("");
        for (String command : commands) {
            commandControl.execute(command);
        }
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + position.formattedPosition();
    }
}