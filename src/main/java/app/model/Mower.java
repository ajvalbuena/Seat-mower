package app.model;

import java.util.Objects;

public class Mower {

    private Point point;
    private CardinalPoint cardinalPoint;

    public Mower(Point point, CardinalPoint cardinalPoint) {
        this.point = point;
        this.cardinalPoint = cardinalPoint;
    }


    public Mower move() {
        return new Mower(new Point(0,1), CardinalPoint.N);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(point, mower.point) && cardinalPoint == mower.cardinalPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, cardinalPoint);
    }
}
