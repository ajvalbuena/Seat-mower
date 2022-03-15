package app.model;

import java.util.HashMap;
import java.util.Map;

public class LeftInstruction extends Instruction {


    public LeftInstruction() {
        super(new HashMap<>() {{
            put(CardinalPoint.N, new DirectionMovement(CardinalPoint.W));
            put(CardinalPoint.S, new DirectionMovement(CardinalPoint.E));
            put(CardinalPoint.E, new DirectionMovement(CardinalPoint.N));
            put(CardinalPoint.W, new DirectionMovement(CardinalPoint.S));
        }});
    }
}
