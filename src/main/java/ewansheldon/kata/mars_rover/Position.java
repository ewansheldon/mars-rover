package ewansheldon.kata.mars_rover;

import static java.lang.String.format;

public class Position {
    public static final String POSITION_RESPONSE_FORMAT = "%s:%s:%s";
    private Thrust thrust;
    private final Orientation orientation;

    public Position(Thrust thrust, Orientation orientation) {
        this.thrust = thrust;
        this.orientation = orientation;
    }

    public String formattedPosition() {
        int[] coordinates = thrust.getCoordinates();
        String direction = orientation.getDirection();

        return format(POSITION_RESPONSE_FORMAT,
                coordinates[0], coordinates[1], direction);

    }
}
