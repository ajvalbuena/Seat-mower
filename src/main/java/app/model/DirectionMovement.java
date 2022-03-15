package app.model;

public class DirectionMovement implements Movement{

    private CardinalPoint cardinalPoint;

    public DirectionMovement(CardinalPoint cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    @Override
    public Mower applyVector(Mower mower) {
        return new Mower(mower.getPoint(), cardinalPoint);
    }
}
