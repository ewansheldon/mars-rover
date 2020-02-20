package ewansheldon.kata.mars_rover;

import java.util.HashMap;
import java.util.Map;

public class CommandControl {
    private Position position;
    private Map<Character, Command> commands = new HashMap<>();
    private Orientation orientation;

    public CommandControl(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        createCommands();
    }

    private void createCommands() {
//        this.commands = Map.of(
//                'M', new MoveForward(position),
//                'L', new TurnLeft(orientation),
//                'R', new TurnRight(orientation)
//        );
        commands.put('M', new MoveForward(position));
        commands.put('L', new TurnLeft(orientation));
        commands.put('R', new TurnRight(orientation));
    }

    public void execute(char commandCode) throws ObstacleEncounteredException {
        executeCommand(commands.get(commandCode));
    }

    private void executeCommand(Command command) throws ObstacleEncounteredException {
        command.execute();
    }

    public String currentDirection() {
        return position.currentDirection();
    }

    public int[] getCoordinates() {
        return position.getCoordinates();
    }
}
