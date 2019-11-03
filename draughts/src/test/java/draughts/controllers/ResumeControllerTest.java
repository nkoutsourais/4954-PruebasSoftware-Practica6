package draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import draughts.models.*;

public class ResumeControllerTest {

    State state = new State();
    ResumeController resumeController;

    public ResumeControllerTest() {
        while(state.getValueState() != StateValue.FINAL)
            state.next();
        resumeController = new ResumeController(new Game(), state);
    }

    @Test
    public void givenResumeControllerWhenNewGameThenStateIsInitial() {
        resumeController.resume(true);
        assertEquals(StateValue.INITIAL, state.getValueState());
    }

    @Test
    public void givenResumeControllerWhenExitThenStateIsExit() {
        resumeController.resume(false);
        assertEquals(StateValue.EXIT, state.getValueState());
    }
}