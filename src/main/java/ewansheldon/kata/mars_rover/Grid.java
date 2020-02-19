package ewansheldon.kata.mars_rover;

public class Grid {
    private int[] limits;
    private int LOWER_LIMIT = 0;
    private int[][] obstacles;

    public Grid(int[] ...obstacles) {
        this.limits = new int[]{10, 10};
        this.obstacles = obstacles;
    }

    public int[] confirmCoordinates(int[] newCoordinates) throws ObstacleEncounteredException {
        for (int i = 0; i < 2; i++) {
            int coordinate = newCoordinates[i];
            if (beyondUpperLimit(coordinate, i)) newCoordinates[i] = 0;
            if (beyondLowerLimit(coordinate)) newCoordinates[i] = limits[i] - 1;
        }

        if (isObstacle(newCoordinates)) throw new ObstacleEncounteredException();
        return newCoordinates;
    }

    private boolean isObstacle(int[] newCoordinates) {
        for (int i = 0; i < obstacles.length; i++) {
            if (newCoordinates.equals(obstacles[i])) {
                return true;
            }
        }

        return false;
    }

    private boolean beyondLowerLimit(int newCoordinate) {
        return newCoordinate < LOWER_LIMIT;
    }

    private boolean beyondUpperLimit(int newCoordinate, int i) {
        return newCoordinate == limits[i];
    }
}
