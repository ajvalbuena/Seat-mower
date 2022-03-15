package app.model;

public class DirectionMovement implements Movement{

    private CardinalPoint cardinalPoint;

    public DirectionMovement(CardinalPoint cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    @Override
    public Mower applyVector(Mower mower, Point plateauUpperLimits) {
        return new Mower(mower.getPoint(), cardinalPoint);
    }
}
