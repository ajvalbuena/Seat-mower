package app.model;

public class PositionMovement implements Movement {

    private int x;
    private int y;

    public PositionMovement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Mower applyVector(Mower mower, Point plateauUpperLimits) throws Exception {
        int newX = this.x + mower.getPoint().getX();
        int newY = this.y + mower.getPoint().getY();
        try {
            Point positionAfterMovement = new Point(applyLimitsPlateau(newX, plateauUpperLimits.getX()), applyLimitsPlateau(newY,
                    plateauUpperLimits.getY()));
            return new Mower(positionAfterMovement, mower.getCardinalPoint());
        } catch (Exception e) {
            throw e;

        }
    }

    private int applyLimitsPlateau(int point, int limit) throws Exception {
        if (point < 0 || point >limit) throw new Exception("Mower is out of the plateau");
        return point;
    }


}
