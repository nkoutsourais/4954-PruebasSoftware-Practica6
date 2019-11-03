package draughts.models;

class FactoryBoard {

    enum Type { 
        INITIAL, 
        SQUARE_OCCUPED, 
        TRANSFORM_DAMA, 
        PEON_JUMP_CAPTURE, 
        DAMA_JUMP_CAPTURE, 
        DAMA_IMPOSSIBLE_MOV, 
        BACKWARD_MOVE,
        TIE,
        ONE_MOV_FOR_WIN, 
        BLACK_BLOKED
    }

    Board getBoard(Type type) {
        return null;
    }
}