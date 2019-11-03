package draughts.views;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;

class ResumeView {

	YesNoDialog dialog = new YesNoDialog();

	public void interact(ResumeController resumeController) {
		resumeController.resume(dialog.read(MessageView.RESUME.getMessage()));
	}
}