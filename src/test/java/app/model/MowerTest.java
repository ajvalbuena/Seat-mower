package app.model;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class MowerTest {

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInNorth() {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var finalMower = new Mower(new Point(0, 1), CardinalPoint.E);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new RightInstruction())), finalMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnLeftStatingInNorth() {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var finalMower = new Mower(new Point(0, 1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new LeftInstruction())), finalMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInSouth() {
        var initialMower = new Mower(new Point(2, 2), CardinalPoint.S);
        var finalMower = new Mower(new Point(2, 1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new RightInstruction())), finalMower);
    }

    @Test
    public void itShouldMoveAndTurnMowerInEveryDirection() {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var finalMower = new Mower(new Point(1, 1), CardinalPoint.S);

        List<Instruction> listOfInstructions = Arrays.asList(new RightInstruction(), new MoveInstruction(), new LeftInstruction(),
                new MoveInstruction(), new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new RightInstruction(),
                new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new LeftInstruction());

        assertEquals(initialMower.move(listOfInstructions), finalMower);
    }

}