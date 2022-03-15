package app.model;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class MowerTest {

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInNorth() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(0, 1), CardinalPoint.E);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new RightInstruction())), expectedMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnLeftStatingInNorth() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(0, 1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new LeftInstruction())), expectedMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInSouth() throws Exception {
        var initialMower = new Mower(new Point(2, 2), CardinalPoint.S);
        var expectedMower = new Mower(new Point(2, 1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList(new MoveInstruction(), new RightInstruction())), expectedMower);
    }

    @Test
    public void itShouldMoveAndTurnMowerInEveryDirection() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(1, 1), CardinalPoint.S);

        List<Instruction> listOfInstructions = Arrays.asList(new RightInstruction(), new MoveInstruction(), new LeftInstruction(),
                new MoveInstruction(), new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new RightInstruction(),
                new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new LeftInstruction());

        assertEquals(initialMower.move(listOfInstructions), expectedMower);
    }

    @Test(expectedExceptions = {Exception.class})
    public void itShouldStopMowerBeforeGettingOutOfThePlateau() throws Exception {
        var initialMower = new Mower(new Point(1, 1), CardinalPoint.S);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new MoveInstruction(), new MoveInstruction());
        initialMower.move(listOfInstructions);
    }

}