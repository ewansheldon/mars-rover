import ewansheldon.kata.mars_rover.Grid;
import ewansheldon.kata.mars_rover.ObstacleEncounteredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridShould {
    private static final int OUTER_LIMIT = 9;
    private static final int LOWER_LIMIT = 0;
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
    }

    @Test
    void return_same_coordinates_if_normal() throws ObstacleEncounteredException {
        int[] coordinates = new int[]{1,1};
        assertEquals(coordinates, grid.confirmCoordinates(coordinates));
    }

    @Test
    void return_wrapped_coordinates_beyond_outer_limit() throws ObstacleEncounteredException {
        int[] coordinates = new int[]{OUTER_LIMIT + 1, 1};
        assertArrayEquals(new int[]{0,1}, grid.confirmCoordinates(coordinates));
    }

    @Test
    void return_wrapped_coordinates_beyond_lower_limit() throws ObstacleEncounteredException {
        int[] coordinates = new int[]{LOWER_LIMIT - 1, 1};
        assertArrayEquals(new int[]{OUTER_LIMIT,1}, grid.confirmCoordinates(coordinates));
    }
}
