package app.model;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class MowerTest {

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInNorth() {
        var initialMower = new Mower(new Point(0,0), CardinalPoint.N);
        var finalMower = new Mower(new Point(0,1), CardinalPoint.E);

        assertEquals(initialMower.move(Arrays.asList("M", "R")), finalMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnLeftStatingInNorth() {
        var initialMower = new Mower(new Point(0,0), CardinalPoint.N);
        var finalMower = new Mower(new Point(0,1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList("M", "L")), finalMower);
    }

    @Test
    public void itShouldMoveMowerOneStepForwardAndTurnRightStatingInSouth() {
        var initialMower = new Mower(new Point(2,2), CardinalPoint.S);
        var finalMower = new Mower(new Point(2,1), CardinalPoint.W);

        assertEquals(initialMower.move(Arrays.asList("M", "R")), finalMower);
    }

    @Test
    public void itShouldMoveAndTurnMowerInEveryDirection() {
        var initialMower = new Mower(new Point(0,0), CardinalPoint.N);
        var finalMower = new Mower(new Point(1,1), CardinalPoint.S);

        assertEquals(initialMower.move(Arrays.asList("R", "M", "L", "M", "M", "R", "M", "R","M","R", "M", "L")), finalMower);
    }

}