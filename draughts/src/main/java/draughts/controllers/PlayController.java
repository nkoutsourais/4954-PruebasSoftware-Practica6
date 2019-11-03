package draughts.controllers;

import draughts.models.*;
import draughts.models.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(AcceptController controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.game.move(origin, target);
    }

    public String printGame() {
        return this.game.toString();
    }

    public Color getTurnColor() {
        return this.game.getTurnColor();
    }

    public void nextState() {
        this.state.next();
    }

    public boolean isFinishGame() {
        return this.game.isFinished();
    }
}