package draughts.models;

public class Square {

    private Piece piece;

    Square() {
    }

    void put(Piece piece) {
        this.piece = piece;
    }

    Piece remove() {
        Piece piece = this.piece;
        this.piece = null;
        return piece;
    }

    Piece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }
}