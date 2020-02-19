package ewansheldon.kata.mars_rover;

public class Position {
    private int[] coordinates;
    private Grid grid;
    private Orientation orientation;

    public Position(Grid grid, Orientation orientation) {
        this.grid = grid;
        this.orientation = orientation;
        this.coordinates = new int[]{0,0};
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void move() throws ObstacleEncounteredException {
        int[] newCoordinates = addMovementVector(coordinates, getNextPosition().movementVector);

        try {
            coordinates = grid.confirmCoordinates(newCoordinates);
        } catch (Exception e) {
            throw new ObstacleEncounteredException();
        }
    }

    private int[] addMovementVector(int[] origin, int[] vector) {
        for (int i = 0; i < 2; i++) {
            origin[i] += vector[i];
        }

        return origin;
    }

    private NextPosition getNextPosition() {
        return NextPosition.valueOf(currentDirection());
    }

    public String currentDirection() {
        return orientation.getDirection();
    }

    public void turnRight() {
        orientation.turnRight();
    }

    public void turnLeft() {
        orientation.turnLeft();
    }
}
