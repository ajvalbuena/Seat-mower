package app.application;

import app.model.*;
import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerrainInspection {
    public static String inspectWithMower(String initialMower, String instructionsInput) {
        if (Strings.isNullOrEmpty(initialMower)) return new Mower(new Point(0, 0), CardinalPoint.N).convertToString();

        Mower myMower = createInitialMower(initialMower);

        if (Strings.isNullOrEmpty(instructionsInput)) return myMower.convertToString();

        return myMower.move(createListOfInstructionsFromCommands(instructionsInput)).convertToString();
    }

    private static Mower createInitialMower(String initialMower) {
        List<String> mowerAttributes = Arrays.asList(initialMower.split(" "));
        CardinalPoint cardinalPoint = CardinalPoint.valueOf(mowerAttributes.get(2));
        int x = Integer.parseInt(mowerAttributes.get(0));
        int y = Integer.parseInt(mowerAttributes.get(1));

        return new Mower(new Point(x, y), cardinalPoint);
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

}
