package ewansheldon.kata.mars_rover;

import java.util.Arrays;

public class Grid {
    private static final int LOWER_LIMIT = 0;
    private static final int[] LIMITS = new int[]{10, 10};
    private int[][] obstacles;

    public Grid(int[] ...obstacles) {
        this.obstacles = obstacles;
    }

    public int[] confirmCoordinates(int[] newCoordinates) throws ObstacleEncounteredException {
        for (int i = 0; i < 2; i++) {
            int coordinate = newCoordinates[i];
            if (beyondUpperLimit(coordinate, i)) newCoordinates[i] = 0;
            if (beyondLowerLimit(coordinate)) newCoordinates[i] = LIMITS[i] - 1;
        }

        if (isObstacle(newCoordinates)) throw new ObstacleEncounteredException();
        return newCoordinates;
    }

    private boolean isObstacle(int[] newCoordinates) {
        for (int[] obstacle : obstacles) {
            if (Arrays.equals(newCoordinates, obstacle)) {
                return true;
            }
        }

        return false;
    }

    private boolean beyondLowerLimit(int newCoordinate) {
        return newCoordinate < LOWER_LIMIT;
    }

    private boolean beyondUpperLimit(int newCoordinate, int i) {
        return newCoordinate == LIMITS[i];
    }
}
