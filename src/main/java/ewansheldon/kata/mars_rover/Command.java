package ewansheldon.kata.mars_rover;

public interface Command {
    void execute() throws ObstacleEncounteredException;
}
