package ewansheldon.kata.mars_rover;

import java.util.Map;

public class CommandControl {
    public static final char MOVE = 'M';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    private Map<Character, Command> commands;
    private Orientation orientation;
    private Thrust thrust;

    public CommandControl(Orientation orientation, Thrust thrust) {
        this.orientation = orientation;
        this.thrust = thrust;
        createCommands();
    }

    private void createCommands() {
        this.commands = Map.of(
                MOVE, new MoveForward(thrust),
                LEFT, new TurnLeft(orientation),
                RIGHT, new TurnRight(orientation)
        );
    }

    public void execute(char commandCode) throws ObstacleEncounteredException {
        Command command = commands.get(commandCode);
        if (command != null) executeCommand(command);
    }

    private void executeCommand(Command command) throws ObstacleEncounteredException {
        command.execute();
    }
}
