package app.application;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TerrainInspectionTest {

    static final String MOWER_OUT_OF_PLATEAU = "Mower cannot get off the plateau";
    static final String plateauUpperLimit = "10 10";

    @Test
    public void shouldReturnDefaultMowerWhenItIsNotDefined() {
        String emptyMower = "";
        String finalMower = TerrainInspection.inspectWithMower(plateauUpperLimit, emptyMower, null);

        assertEquals(finalMower, "0 0 N");
    }

    @Test
    public void shouldNotMoveMowerWhenThereIsNoInstructions() {
        String initialMower = "4 4 E";
        String instructionsInput = "";
        String finalMower = TerrainInspection.inspectWithMower(plateauUpperLimit, initialMower, instructionsInput);

        assertEquals(finalMower, initialMower);
    }

    @Test
    public void shouldMoveOneMowerToTheCorrectPosition() {
        String instructionsInput = "MRMMLMMLLMR";
        String initialMower = "0 0 N";
        String finalMower = TerrainInspection.inspectWithMower(plateauUpperLimit, initialMower, instructionsInput);

        assertEquals(finalMower, "2 2 W");
    }

    @Test
    public void shouldTake100AsDefaultUpperYLimit() {
        String instructionsInput = "MM";
        String initialMower = "99 99 N";

        String result = TerrainInspection.inspectWithMower("",initialMower, instructionsInput);

        assertEquals(result, MOWER_OUT_OF_PLATEAU);
    }

    @Test
    public void shouldTake100AsDefaultUpperXLimit() {
        String instructionsInput = "RMM";
        String initialMower = "99 99 N";

        String result = TerrainInspection.inspectWithMower("",initialMower, instructionsInput);

        assertEquals(result, MOWER_OUT_OF_PLATEAU);
    }

    @Test
    public void shouldNotGetOffBelowYLimit() {
        String instructionsInput = "MM";
        String initialMower = "1 1 S";

        String result = TerrainInspection.inspectWithMower(plateauUpperLimit,initialMower, instructionsInput);

        assertEquals(result, MOWER_OUT_OF_PLATEAU);
    }

    @Test
    public void shouldNotGetOffBelowXLimit() {
        String instructionsInput = "RMM";
        String initialMower = "1 1 S";

        String result = TerrainInspection.inspectWithMower(plateauUpperLimit,initialMower, instructionsInput);

        assertEquals(result, MOWER_OUT_OF_PLATEAU);
    }

}