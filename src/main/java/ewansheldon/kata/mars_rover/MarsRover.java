package ewansheldon.kata.mars_rover;

public class MarsRover {
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
            return position.formattedPosition();
        } catch (ObstacleEncounteredException e) {
            return obstacleResponse();
        }
    }

    private void executeCommands() throws ObstacleEncounteredException {
        for (int i = 0; i < commands.length(); i++) {
            commandControl.execute(commands.charAt(i));
        }
    }

    private String obstacleResponse() {
        return OBSTACLE_FLAG + position.formattedPosition();
    }
}