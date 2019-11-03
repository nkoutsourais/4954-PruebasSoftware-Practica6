package draughts.controllers;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.models.*;

@RunWith(MockitoJUnitRunner.class)
public class ResumeControllerTest {

    @Mock
    State state;

    @Mock
    Game game;

    @Before
    public void before(){
        when(state.getValueState()).thenReturn(StateValue.FINAL);
    }
    
    @Test
    public void givenResumeControllerWhenNewGameThenResetGame() {
        ResumeController resumeController = new ResumeController(game, state);
        resumeController.resume(true);
        verify(state).reset();
        verify(game).reset();
        verify(state, never()).next();
    }

    @Test
    public void givenResumeControllerWhenExitThenExitGame() {
        ResumeController resumeController = new ResumeController(new Game(), state);
        resumeController.resume(false);
        verify(state, never()).reset();
        verify(game, never()).reset();
        verify(state).next();
    }
}