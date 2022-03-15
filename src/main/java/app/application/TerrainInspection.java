package app.application;

import app.model.*;
import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerrainInspection {

    final static int UPPER_X_LIMIT = 100;
    final static int UPPER_Y_LIMIT = 100;

    public static String inspectWithMower(String plateauLimits, String initialMower, String instructionsInput) {
        try {
            if (Strings.isNullOrEmpty(initialMower)) return new Mower(new Point(0, 0), CardinalPoint.N).convertToString();

            Mower myMower = createInitialMower(initialMower);
            Point plateauUpperLimits = createPlateauLimits(plateauLimits);

            if (Strings.isNullOrEmpty(instructionsInput)) return myMower.convertToString();

            return myMower.move(createListOfInstructionsFromCommands(instructionsInput), plateauUpperLimits).convertToString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static Point createPlateauLimits(String plateauLimits) {
        if(Strings.isNullOrEmpty(plateauLimits)) return new Point(UPPER_X_LIMIT, UPPER_Y_LIMIT);
        List<String> plateauUpperLimits = Arrays.asList(plateauLimits.split(" "));

        return createPointInTheGrid(plateauUpperLimits);
    }

    private static Mower createInitialMower(String initialMower) {
        List<String> mowerAttributes = Arrays.asList(initialMower.split(" "));
        CardinalPoint cardinalPoint = CardinalPoint.valueOf(mowerAttributes.get(2));

        return new Mower(createPointInTheGrid(mowerAttributes), cardinalPoint);
    }

    private static List<Instruction> createListOfInstructionsFromCommands(String commands) {
        return commands.chars().mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(TerrainInspection::createInstructionFromCommand)
                .collect(Collectors.toList());
    }

    private static Instruction createInstructionFromCommand(String command) {
        if (command.equals("M")) return new MoveInstruction();
        else if (command.equals("L")) return new LeftInstruction();
        else return new RightInstruction();
    }

    private static Point createPointInTheGrid(List<String> points) {
        int x = Integer.parseInt(points.get(0));
        int y = Integer.parseInt(points.get(1));

        return new Point(x, y);
    }

}
