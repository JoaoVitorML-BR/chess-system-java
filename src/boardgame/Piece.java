package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null; // Initially, the piece has no position
    }

    protected Board getBoard() { // Protected method not to expose the board outside the package
        return board;
    }
}
