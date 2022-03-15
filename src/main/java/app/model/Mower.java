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
        int x = this.point.getX();
        int y = this.point.getY();
        CardinalPoint cardinal = this.cardinalPoint;

        for (String instruction : instructions) {
            if (cardinal.equals(CardinalPoint.N)) {
                if (instruction.equals("M")) {
                    y += 1;
                } else if (instruction.equals("R")) {
                    cardinal = CardinalPoint.E;
                } else if (instruction.equals("L")) {
                    cardinal = CardinalPoint.W;
                }
            }else if (cardinal.equals(CardinalPoint.S)) {
                if (instruction.equals("M")) {
                    y -= 1;
                } else if (instruction.equals("R")) {
                    cardinal = CardinalPoint.W;
                } else if (instruction.equals("L")) {
                    cardinal = CardinalPoint.E;
                }
            }else if (cardinal.equals(CardinalPoint.W)) {
                if (instruction.equals("M")) {
                    x -= 1;
                } else if (instruction.equals("R")) {
                    cardinal = CardinalPoint.N;
                } else if (instruction.equals("L")) {
                    cardinal = CardinalPoint.S;
                }
            }else {
                if (instruction.equals("M")) {
                    x += 1;
                } else if (instruction.equals("R")) {
                    cardinal = CardinalPoint.S;
                } else if (instruction.equals("L")) {
                    cardinal = CardinalPoint.N;
                }
            }

        }
        return new Mower(new Point(x, y), cardinal);
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
