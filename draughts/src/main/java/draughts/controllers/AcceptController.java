package draughts.controllers;

public interface AcceptController {

    void visit(StartController startController);

    void visit(PlayController proposeCombinationController);

    void visit(ResumeController resumeController);
}