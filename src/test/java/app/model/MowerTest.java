package app.model;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MowerTest {

    final Point plateauUpperLimit = new Point(100, 100);

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInNorth() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(0, 1), CardinalPoint.E);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new RightInstruction());
        var finalMower = initialMower.move(listOfInstructions, plateauUpperLimit);

        assertEquals(finalMower, expectedMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnLeftStatingInNorth() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(0, 1), CardinalPoint.W);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new LeftInstruction());
        var finalMower = initialMower.move(listOfInstructions, plateauUpperLimit);

        assertEquals(finalMower, expectedMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInSouth() throws Exception {
        var initialMower = new Mower(new Point(2, 2), CardinalPoint.S);
        var expectedMower = new Mower(new Point(2, 1), CardinalPoint.W);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new RightInstruction());
        var finalMower = initialMower.move(listOfInstructions, plateauUpperLimit);

        assertEquals(finalMower, expectedMower);
    }

    @Test
    public void itShouldMoveAndTurnMowerInEveryDirection() throws Exception {
        var initialMower = new Mower(new Point(0, 0), CardinalPoint.N);
        var expectedMower = new Mower(new Point(1, 1), CardinalPoint.S);

        List<Instruction> listOfInstructions = Arrays.asList(new RightInstruction(), new MoveInstruction(), new LeftInstruction(),
                new MoveInstruction(), new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new RightInstruction(),
                new MoveInstruction(), new RightInstruction(), new MoveInstruction(), new LeftInstruction());
        var finalMower = initialMower.move(listOfInstructions, plateauUpperLimit);

        assertEquals(finalMower, expectedMower);
    }

    @Test(expectedExceptions = {Exception.class})
    public void itShouldNoticeTheMowerIsBelowOfThePlateau() throws Exception {
        var initialMower = new Mower(new Point(1, 1), CardinalPoint.S);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new MoveInstruction(), new MoveInstruction());
        initialMower.move(listOfInstructions, plateauUpperLimit);
    }

    @Test(expectedExceptions = {Exception.class})
    public void itShouldNoticeTheMowerIsOutOfThePlateauYLimit() throws Exception {
        var initialMower = new Mower(new Point(0, 5), CardinalPoint.N);
        var upperLimits = new Point(2, 6);

        List<Instruction> listOfInstructions = Arrays.asList(new MoveInstruction(), new MoveInstruction(), new MoveInstruction());
        initialMower.move(listOfInstructions, upperLimits);
    }

    @Test(expectedExceptions = {Exception.class})
    public void itShouldNoticeTheMowerIsOutOfThePlateauXLimit() throws Exception {
        var initialMower = new Mower(new Point(0, 5), CardinalPoint.N);
        var upperLimits = new Point(2, 6);

        List<Instruction> listOfInstructions = Arrays.asList(new RightInstruction(), new MoveInstruction(), new MoveInstruction(), new MoveInstruction());
        initialMower.move(listOfInstructions, upperLimits);
    }

}