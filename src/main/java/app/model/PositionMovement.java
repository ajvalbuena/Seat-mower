package app.model;

public class PositionMovement implements Movement {

    private int x;
    private int y;

    public PositionMovement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Mower applyVector(Mower mower) {
        Point positionAfterMovement = new Point(x + mower.getPoint().getX(), y + mower.getPoint().getY());
        return new Mower(positionAfterMovement, mower.getCardinalPoint());
    }
}
