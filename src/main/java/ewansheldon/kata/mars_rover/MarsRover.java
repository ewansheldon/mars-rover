package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class MarsRover {
    public static final int RIGHT = 1;
    public static final int LEFT = -1;
    private int[] coordinates;
    private int dir = 0;
    private String commands;
    private Grid grid;
    private char[] directions = new char[]{'N','E','S','W'};

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.coordinates = new int[]{0,0};
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

    private String obstacleResponse() {
        return "O:" + formattedPosition();
    }

    private String formattedPosition() {
        return format("%s:%s:%s", coordinates[0], coordinates[1], compassDir());
    }

    private char compassDir() {
        return directions[directionIndex()];
    }

    private int directionIndex() {
        int index = dir % 4;
        while (index < 0) index += 4;
        return index;
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
                rotate(RIGHT);
                break;
            case 'L':
                rotate(LEFT);
                break;
        }
    }

    private void rotate(int directionFactor) {
        dir += directionFactor;
    }

    private void move() throws ObstacleEncounteredException {
        int[] newCoordinates = coordinates;
        switch (directionIndex()) {
            case 0:
                newCoordinates[1]++;
                break;
            case 1:
                newCoordinates[0]++;
                break;
            case 2:
                newCoordinates[1]--;
                break;
            case 3:
                newCoordinates[0]--;
                break;
        }

        try {
            coordinates = grid.confirmCoordinates(newCoordinates);
        } catch (Exception e) {
            throw new ObstacleEncounteredException();
        }
    }
}