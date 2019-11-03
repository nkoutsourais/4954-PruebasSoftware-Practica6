package draughts.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TurnTest {

    @Test
    public void givenTurnWhenChangeTurnThenNoErrorColor() {
        Turn turn = new Turn();
        assertTrue(turn.isColor(Color.WHITE));
        turn.change();
        assertTrue(turn.isColor(Color.BLACK));
        turn.change();
        assertTrue(turn.isColor(Color.WHITE));
    }
}