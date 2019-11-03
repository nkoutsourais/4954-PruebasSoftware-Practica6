package draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardThenGoodLocations() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Piece piece = board.getPiece(coordinate);
                if (coordinate.isBlack()) {
                    assertEquals(Color.BLACK, piece.getColor());
                } else {
                    assertNull(piece);
                }
            }
        }
        for (int i = 5; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Piece piece = board.getPiece(coordinate);
                if (coordinate.isBlack()) {
                    assertEquals(Color.WHITE, piece.getColor());
                } else {
                    assertNull(piece);
                }
            }
        }
    }

    @Test
    public void givenBoardWhenMovementThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.board.move(origin, target);
        assertNull(this.board.getPiece(origin));
        Piece pieceTarget = this.board.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
}