package draughts.views;

import draughts.controllers.StartController;
import draughts.utils.WithConsoleView;

class StartView extends WithConsoleView {

    public void interact(StartController startController) {
        startController.start();
        console.writeln(MessageView.TITLE.getMessage());
    }
}