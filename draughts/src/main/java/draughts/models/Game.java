package draughts.models;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		reset();
	}

	public Error move(Coordinate origin, Coordinate target) {
		if (!origin.isValid() || !target.isValid()) {
			return Error.OUT_COORDINATE;
		}
		if (board.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		Color color = this.board.getPiece(origin).getColor();
		if (!this.turn.isColor(color)) {
			return Error.OPPOSITE_PIECE;
		}
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		Piece piece = this.board.getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.board.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
			this.board.remove(between);
		}
		this.board.move(origin, target);
		this.turn.change();
		return null;
	}

	@Override
	public String toString() {
		return this.board.toString();
	}

	public void reset() {
		this.board = new Board();
		this.turn = new Turn();
	}

	public Color getTurnColor() {
		return this.turn.getColor();
	}

	public boolean isFinished() {
		return !this.board.containsPieces(this.turn.getColor());
	}
}