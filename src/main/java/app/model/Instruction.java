package app.model;

import java.util.Map;

public abstract class Instruction {

    private Map<CardinalPoint, Movement> cardinalPointMovementMap;

    public Instruction(Map<CardinalPoint, Movement> cardinalPointMovementMap) {
        this.cardinalPointMovementMap = cardinalPointMovementMap;
    }

    public Mower applyInstruction(Mower mower, Point plateauUpperLimits) throws Exception {
        try {
            return cardinalPointMovementMap.get(mower.getCardinalPoint()).applyVector(mower, plateauUpperLimits);
        } catch (Exception e) {
            throw e;
        }
    }
}
