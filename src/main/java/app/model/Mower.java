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


    public Mower move(List<String> instructions) {
        var movingMower = this;

        for (String instruction : instructions) {
            if (instruction.equals("M")) {
                movingMower = new MoveInstruction().applyInstruction(movingMower);
            } else if (instruction.equals("R")) {
                movingMower = new RightInstruction().applyInstruction(movingMower);
            } else {
                movingMower = new LeftInstruction().applyInstruction(movingMower);
            }

        }
        return movingMower;
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
