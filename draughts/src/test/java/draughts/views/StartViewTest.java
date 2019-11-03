package draughts.views;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.StartController;

@RunWith(MockitoJUnitRunner.class)
public class StartViewTest {

    @Mock
    StartController startController;

    @Test
    public void givenStartViewWhenInteractThenStart() {
        new StartView().interact(startController);
        verify(startController, times(1)).start();
        verifyNoMoreInteractions(startController);
    }
}