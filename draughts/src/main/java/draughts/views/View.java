package draughts.views;

import draughts.controllers.*;

public interface View extends AcceptController {
    void interact(Controller controller);
}