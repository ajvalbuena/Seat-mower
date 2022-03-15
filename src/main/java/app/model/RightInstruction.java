package app.model;

import java.util.HashMap;

public class RightInstruction extends Instruction {


    public RightInstruction() {
        super(new HashMap<>() {{
            put(CardinalPoint.N, new DirectionMovement(CardinalPoint.E));
            put(CardinalPoint.S, new DirectionMovement(CardinalPoint.W));
            put(CardinalPoint.E, new DirectionMovement(CardinalPoint.S));
            put(CardinalPoint.W, new DirectionMovement(CardinalPoint.N));
        }});
    }
}
