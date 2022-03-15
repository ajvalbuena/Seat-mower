package app.model;

import java.util.List;
import java.util.Objects;

public class Mower {

    private Point point;

    private CardinalPoint cardinalPoint;

    public Mower(Point point, CardinalPoint cardinalPoint) {
        this.point = point;
        this.cardinalPoint = cardinalPoint;
    }


    public Mower move(List<Instruction> instructions) {
        var movingMower = this;

        for (Instruction instruction : instructions) {
            movingMower = instruction.applyInstruction(movingMower);

        }
        return movingMower;
    }

    public String convertToString() {
        String x = String.valueOf(point.getX());
        String y = String.valueOf(point.getY());
        String cardinal = cardinalPoint.name();

        return x + " " + y + " " + cardinal;
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

    public Point getPoint() {
        return point;
    }

    public CardinalPoint getCardinalPoint() {
        return cardinalPoint;
    }
}
