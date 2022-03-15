package app.model;

public class RightInstruction implements Instruction {

    @Override
    public Mower applyInstruction(Mower mower) {
        CardinalPoint mowerCardinal = mower.getCardinalPoint();

        if (mowerCardinal.equals(CardinalPoint.N)) {
            return new Mower(mower.getPoint(), CardinalPoint.E);
        } else if (mowerCardinal.equals(CardinalPoint.S)) {
            return new Mower(mower.getPoint(), CardinalPoint.W);
        } else if (mowerCardinal.equals(CardinalPoint.E)) {
            return new Mower(mower.getPoint(), CardinalPoint.S);
        } else {
            return new Mower(mower.getPoint(), CardinalPoint.N);
        }
    }
}
