package ewansheldon.kata.mars_rover;

public enum NextPosition {
    N ("W", "E", new int[]{0,1}),
    E ("N", "S", new int[]{1,0}),
    S ("E", "W", new int[]{0,-1}),
    W ("S", "N", new int[]{-1,0});

    public final String left;
    public final String right;
    public final int[] movementVector;

    NextPosition(String left, String right, int[] movementVector) {
        this.left = left;
        this.right = right;
        this.movementVector = movementVector;
    }
}
