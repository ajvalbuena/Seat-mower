package app.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MowerTest {

    @Test
    public void itShouldMoveMowerOne() {
        var initialMower = new Mower(new Point(0,0), CardinalPoint.N);
        var finalMower = new Mower(new Point(0,1), CardinalPoint.N);

        assertEquals(initialMower.move(), finalMower);

    }

}