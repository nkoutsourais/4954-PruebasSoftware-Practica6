package draughts.views;

import draughts.controllers.Controller;
import draughts.controllers.PlayController;
import draughts.controllers.ResumeController;
import draughts.controllers.StartController;
import draughts.utils.WithConsoleView;

public class ConsoleView extends WithConsoleView implements View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        new StartView().interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        new PlayView().interact(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        new ResumeView().interact(resumeController);
    }
}