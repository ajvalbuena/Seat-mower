package app.application;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TerrainInspectionTest {

    @Test
    public void shouldReturnDefaultMowerWhenThereIsNoOneDefined() {
        String emptyMower = "";
        String finalMower = TerrainInspection.inspectWithMower(emptyMower, null);

        assertEquals(finalMower, "0 0 N");
    }

    @Test
    public void shouldNotMoveMowerWhenThereIsNoInstructions() {
        String initialMower = "4 4 E";
        String instructionsInput = "";
        String finalMower = TerrainInspection.inspectWithMower(initialMower, instructionsInput);

        assertEquals(finalMower, initialMower);
    }

    @Test
    public void shouldMoveOneMowerToTheCorrectPosition() {
        String instructionsInput = "MRMMLMMLLMR";
        String initialMower = "0 0 N";
        String finalMower = TerrainInspection.inspectWithMower(initialMower, instructionsInput);

        assertEquals(finalMower, "2 2 W");
    }

}