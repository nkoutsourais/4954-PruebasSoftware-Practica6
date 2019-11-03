package draughts.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    Coordinate coordinate;

    @Mock
    Board board;

    @Mock
    Turn turn;

    @InjectMocks
    Game game;


    @Test()
    public void testGivenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        when(coordinate.isValid()).thenReturn(false);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void testGivenGameWhenMoveEmptySquaerThenEmptySquareError() {
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(true);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.EMPTY_ORIGIN, error);
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false);
        when(board.getPiece(any())).thenReturn(new Piece(Color.BLACK));
        when(turn.isColor(any())).thenReturn(false);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.OPPOSITE_PIECE, error);
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false);
        when(board.getPiece(any())).thenReturn(new Piece(Color.BLACK));
        when(turn.isColor(any())).thenReturn(true);
        when(coordinate.isDiagonal(any())).thenReturn(false);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.NOT_DIAGONAL, error);
    }

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false);
        when(board.getPiece(any())).thenReturn(new Piece(Color.BLACK));
        when(turn.isColor(any())).thenReturn(true);
        when(coordinate.isDiagonal(any())).thenReturn(true);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.NOT_ADVANCED, error);
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        Piece piece = Mockito.mock(Piece.class);
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false);
        when(board.getPiece(any())).thenReturn(piece);
        when(turn.isColor(any())).thenReturn(true);
        when(coordinate.isDiagonal(any())).thenReturn(true);
        when(coordinate.diagonalDistance(any())).thenReturn(4);
        when(piece.isAdvanced(any(), any())).thenReturn(true);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.BAD_DISTANCE, error);
    }

    @Test
    public void testGivenGameWhenNoEmptyTargetThenError() {
        Piece piece = Mockito.mock(Piece.class);
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false);
        when(board.getPiece(any())).thenReturn(piece);
        when(turn.isColor(any())).thenReturn(true);
        when(coordinate.isDiagonal(any())).thenReturn(true);
        when(piece.isAdvanced(any(), any())).thenReturn(true);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }

    @Test
    public void testGivenGameWhenEatEmptyThenError() {
        Piece piece = Mockito.mock(Piece.class);
        when(coordinate.isValid()).thenReturn(true);
        when(board.isEmpty(any())).thenReturn(false).thenReturn(true);
        when(board.getPiece(any())).thenReturn(piece).thenReturn(piece).thenReturn(null);
        when(turn.isColor(any())).thenReturn(true);
        when(coordinate.isDiagonal(any())).thenReturn(true);
        when(coordinate.diagonalDistance(any())).thenReturn(2);
        when(piece.isAdvanced(any(), any())).thenReturn(true);
        Error error = game.move(coordinate, coordinate);
        assertEquals(Error.EATING_EMPTY, error);
    }
}