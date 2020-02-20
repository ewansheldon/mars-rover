package ewansheldon.kata.mars_rover;

import java.util.Map;

public class CommandControl {
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
                'M', new MoveForward(thrust),
                'L', new TurnLeft(orientation),
                'R', new TurnRight(orientation)
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
