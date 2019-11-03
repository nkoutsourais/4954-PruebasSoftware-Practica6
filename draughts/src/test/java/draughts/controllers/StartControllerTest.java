package draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import draughts.models.*;

public class StartControllerTest {

    @Test
    public void givenStartControllerWhenNextStateThenStateIsPlay() {
        State state = new State();
        StartController startController = new StartController(new Game(), state);
        startController.start();
        assertEquals(StateValue.PLAY, state.getValueState());
    }
}