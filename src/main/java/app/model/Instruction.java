package app.model;

import java.util.Map;

public abstract class Instruction {

    private Map<CardinalPoint, Movement> cardinalPointMovementMap;

    public Instruction(Map<CardinalPoint, Movement> cardinalPointMovementMap) {
        this.cardinalPointMovementMap = cardinalPointMovementMap;
    }

    public Mower applyInstruction(Mower mower) throws Exception {
        try {
            return cardinalPointMovementMap.get(mower.getCardinalPoint()).applyVector(mower);
        } catch (Exception e) {
            throw e;
        }
    }
}
