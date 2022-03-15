package app.model;

import java.util.Calendar;
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
            if (instruction.equals("M")) {
                y = +1;
            } else if (instruction.equals("R")) {
                cardinal = CardinalPoint.E;
            } else if(instruction.equals("L")){
                cardinal =CardinalPoint.W;
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
