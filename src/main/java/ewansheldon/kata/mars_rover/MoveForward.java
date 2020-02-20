package ewansheldon.kata.mars_rover;

public class MoveForward implements Command {
    private Thrust thrust;

    public MoveForward(Thrust thrust) {
        this.thrust = thrust;
    }

    @Override
    public void execute() throws ObstacleEncounteredException {
        thrust.move();
    }
}
