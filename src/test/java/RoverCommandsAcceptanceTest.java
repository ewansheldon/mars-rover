import ewansheldon.kata.mars_rover.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverCommandsAcceptanceTest {
    private MarsRover marsRover;
    private String commands;
    private CommandControl commandControl;
    private Position position;
    private Grid grid;
    private Orientation orientation;
    private Thrust thrust;

    @BeforeEach
    void setUp() {
        grid = new Grid();
        orientation = new Orientation();
        thrust = new Thrust(grid, orientation);
        position = new Position(thrust, orientation);
        commandControl = new CommandControl(orientation, thrust);
        marsRover = new MarsRover(position, commandControl);
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

    @Test
    void return_obstacle_and_position_when_encountered() {
        grid = new Grid(new int[]{0,3});
        orientation = new Orientation();
        thrust = new Thrust(grid, orientation);
        position = new Position(thrust, orientation);
        commandControl = new CommandControl(orientation, thrust);
        marsRover = new MarsRover(position, commandControl);
        commands = "MMMM";
        assertEquals("O:0:2:N", marsRover.execute(commands));
    }
}
