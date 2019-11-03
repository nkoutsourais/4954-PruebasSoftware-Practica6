package draughts.models;

public enum Error {
	OUT_COORDINATE, 
    EMPTY_ORIGIN, 
    OPPOSITE_PIECE, 
    NOT_DIAGONAL,
    NOT_EMPTY_TARGET, 
    EATING_EMPTY,
    NOT_ADVANCED,
    BAD_DISTANCE, 
    INCORRECT_COMMAND;
}