package draughts.views;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.PlayController;
import draughts.models.Color;
import draughts.models.Error;
import draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Captor
    private ArgumentCaptor<Error> captor;

    @InjectMocks
    PlayView playView;

    @Test
    public void givenPlayViewWhenCancelThenNextState() {
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(console.readString(anyString())).thenReturn("-1");
        playView.interact(playController);
        verify(playController, times(1)).nextState();
    }

    @Test
    public void givenPlayViewWhenCommandErrorThenNoMovement() {
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(console.readString(anyString())).thenReturn("b.5").thenReturn("-1");
        playView.interact(playController);
        verify(playController, never()).move(any(), any());
    }

    @Test
    public void givenPlayViewWhenCommandCorrectThenMovementOk() {
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(console.readString(anyString())).thenReturn("50.41");
        when(playController.move(any(), any())).thenReturn(null);
        playView.interact(playController);
        verify(playController, times(1)).printGame();
        verify(playController, times(1)).getTurnColor();
        verify(playController, times(1)).move(any(), any());
        verify(playController, times(1)).isFinishGame();
        verifyNoMoreInteractions(playController);
    }

    @Test
    public void givenPlayViewWhenCommandCorrectAndFinishedThenNextState() {
        when(playController.getTurnColor()).thenReturn(Color.WHITE);
        when(console.readString(anyString())).thenReturn("50.41");
        when(playController.move(any(), any())).thenReturn(null);
        when(playController.isFinishGame()).thenReturn(true);
        playView.interact(playController);
        verify(playController, times(1)).printGame();
        verify(playController, times(2)).getTurnColor();
        verify(playController, times(1)).move(any(), any());
        verify(playController, times(1)).isFinishGame();
        verify(playController, times(1)).nextState();
        verifyNoMoreInteractions(playController);
    }
}