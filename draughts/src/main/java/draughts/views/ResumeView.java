package draughts.views;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;

class ResumeView {

	public void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
}