package draughts.views;

import java.util.regex.Pattern;

import draughts.controllers.PlayController;
import draughts.models.Coordinate;
import draughts.utils.WithConsoleView;
import draughts.models.Error;

class PlayView extends WithConsoleView {

    final static String CANCEL_PLAY = "-1";
    final Pattern pattern = Pattern.compile("^\\d{2}+(\\.\\d{2})?$");

    public void interact(PlayController playController) {
        console.writeln(playController.printGame());
        Error error = null;
        do {
            String title = MessageView.TURN.getMessage() + new ColorView(playController.getTurnColor()).getMessage(); 
            String command = this.console.readString(title + ": ");
            if(command.equals(CANCEL_PLAY))
                playController.nextState();
            else {
                if(pattern.matcher(command).matches()) {
                    int origin = Integer.parseInt(command.substring(0, 2));
                    int target = Integer.parseInt(command.substring(3, 5));
                    error = playController.move(new Coordinate(origin/10, origin%10), new Coordinate(target/10, target%10));
                } else {
                    error = Error.INCORRECT_COMMAND;
                }
                if (error != null) {
                    console.writeln(new ErrorView(error).getMessage());
                }
            }
        } while (error != null);
        if(playController.isFinishGame()) {
            console.writeln(new ColorView(playController.getTurnColor()).getMessage() + " " + MessageView.FINAL.getMessage());
            playController.nextState();
        }
	}
}