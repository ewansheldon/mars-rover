package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    private int[] coordinates;
    private String dir;
    private String commands;
    private Grid grid;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.coordinates = new int[]{0, 0};
        this.dir = "N";
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

    private String formattedPosition() {
        return format("%s:%s:%s", coordinates[0], coordinates[1], dir);
    }

    private String obstacleResponse() {
        return "O:" + formattedPosition();
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
                dir = getCommandMap().right;
                break;
            case 'L':
                dir = getCommandMap().left;
                break;
        }
    }

    private void move() throws ObstacleEncounteredException {
        int[] newCoordinates = addMovementVector(coordinates, getCommandMap().movementVector);

        try {
            coordinates = grid.confirmCoordinates(newCoordinates);
        } catch (Exception e) {
            throw new ObstacleEncounteredException();
        }
    }

    private int[] addMovementVector(int[] newCoordinates, int[] movementVector) {
        for (int i = 0; i < 2; i++) {
            newCoordinates[i] += movementVector[i];
        }

        return newCoordinates;
    }

    private CommandMap getCommandMap() {
        return CommandMap.valueOf(dir);
    }

    private enum CommandMap {
        N ("W", "E", new int[]{0,1}),
        E ("N", "S", new int[]{1,0}),
        S ("E", "W", new int[]{0,-1}),
        W ("S", "N", new int[]{-1,0});

        private final String left;
        private final String right;
        private final int[] movementVector;

        CommandMap(String left, String right, int[] movementVector) {
            this.left = left;
            this.right = right;
            this.movementVector = movementVector;
        }
    }
}