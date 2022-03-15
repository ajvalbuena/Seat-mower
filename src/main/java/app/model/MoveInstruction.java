package app.model;

public class MoveInstruction implements Instruction {

    @Override
    public Mower applyInstruction(Mower mower) {
        int mowerX = mower.getPoint().getX();
        int mowerY = mower.getPoint().getY();
        CardinalPoint mowerCardinal = mower.getCardinalPoint();

        if (mowerCardinal.equals(CardinalPoint.N)) {
            return new Mower(new Point(mowerX, mowerY + 1), mowerCardinal);
        } else if (mowerCardinal.equals(CardinalPoint.S)) {
            return new Mower(new Point(mowerX, mowerY - 1), mowerCardinal);
        } else if (mowerCardinal.equals(CardinalPoint.E)) {
            return new Mower(new Point(mowerX + 1, mowerY), mowerCardinal);
        } else {
            return new Mower(new Point(mowerX -1, mowerY), mowerCardinal);
        }
    }
}
