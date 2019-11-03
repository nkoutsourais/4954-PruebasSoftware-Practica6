package draughts.views;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    YesNoDialog dialog;

    @InjectMocks
    ResumeView resumeView;

    @Test
    public void givenResumeViewWhenInteractThenResume() {
        when(dialog.read(anyString())).thenReturn(anyBoolean());
        resumeView.interact(resumeController);
        verify(resumeController, times(1)).resume(anyBoolean());
        verifyNoMoreInteractions(resumeController);
    }
}