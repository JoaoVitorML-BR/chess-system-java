package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null; // Initially, the piece has no position
    }

    protected Board getBoard() { // Protected method not to expose the board outside the package
        return board;
    }

    public abstract boolean[][] possibleMoves(); // Abstract method to be implemented by subclasses

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true; // Found at least one possible move
                }
            }
        }
        return false; // No possible moves found
    }
}
