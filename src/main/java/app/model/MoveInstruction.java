package app.model;

import java.util.HashMap;

public class MoveInstruction extends Instruction {

    public MoveInstruction() {
        super(new HashMap<>() {{
            put(CardinalPoint.N, new PositionMovement(0, 1));
            put(CardinalPoint.S, new PositionMovement(0, -1));
            put(CardinalPoint.E, new PositionMovement(1, 0));
            put(CardinalPoint.W, new PositionMovement(-1, 0));
        }});
    }
}
