import ewansheldon.kata.mars_rover.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {
    private MarsRover marsRover;
    private String commands;

    @BeforeEach
    void setUp() {
        Grid grid = new Grid();
        Orientation orientation = new Orientation();
        Position position = new Position(grid, orientation);
        CommandControl commandControl = new CommandControl(position);
        marsRover = new MarsRover(commandControl);
    }

    @Test
    void return_default_position_with_no_commands_given() {
        commands = "";
        assertEquals("0:0:N", marsRover.execute(commands));
    }

    @Test
    void move_forward_and_return_new_position() {
        commands = "M";
        assertEquals("0:1:N", marsRover.execute(commands));
    }

    @Test
    void turn_right_and_return_new_direction() {
        commands = "R";
        assertEquals("0:0:E", marsRover.execute(commands));
    }

    @Test
    void turn_left_and_return_new_direction() {
        commands = "L";
        assertEquals("0:0:W", marsRover.execute(commands));
    }

    @Test
    void turn_move_and_return_new_position_and_direction() {
        commands = "RM";
        assertEquals("1:0:E", marsRover.execute(commands));
    }

    @Test
    void turn_twice_and_return_new_direction() {
        commands = "RR";
        assertEquals("0:0:S", marsRover.execute(commands));
    }

    @Test
    void executes_combination_command() {
        commands = "MMRMMLM";
        assertEquals("2:3:N", marsRover.execute(commands));
    }

    @Test
    void wrap_when_beyond_plateau_limits() {
        commands = "MMMMMMMMMM";
        assertEquals("0:0:N", marsRover.execute(commands));
    }
}
