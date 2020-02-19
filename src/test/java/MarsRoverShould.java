import ewansheldon.kata.mars_rover.Grid;
import ewansheldon.kata.mars_rover.MarsRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {
    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        Grid grid = new Grid();
        marsRover = new MarsRover(grid);
    }

    @Test
    void return_default_position_with_no_commands_given() {
        assertEquals("0:0:N", marsRover.execute(""));
    }

    @Test
    void move_forward_and_return_new_position() {
        assertEquals("0:1:N", marsRover.execute("M"));
    }

    @Test
    void turn_right_and_return_new_direction() {
        assertEquals("0:0:E", marsRover.execute("R"));
    }

    @Test
    void turn_left_and_return_new_direction() {
        assertEquals("0:0:W", marsRover.execute("L"));
    }

    @Test
    void turn_move_and_return_new_position_and_direction() {
        assertEquals("1:0:E", marsRover.execute("RM"));
    }

    @Test
    void turn_twice_and_return_new_direction() {
        assertEquals("0:0:S", marsRover.execute("RR"));
    }

    @Test
    void executes_combination_command() {
        assertEquals("2:3:N", marsRover.execute("MMRMMLM"));
    }

    @Test
    void wrap_when_beyond_plateau_limits() {
        assertEquals("0:0:N", marsRover.execute("MMMMMMMMMM"));
    }

//    @Test
//    void should_stop_and_return_when_obstacles() {
//        int[] obstacleCoords = new int[]{0,3};
//        Grid grid = new Grid(obstacleCoords);
//        marsRover = new MarsRover(grid);
//        assertEquals("O:0:2:N", marsRover.execute("MMMM"));
//    }
}
