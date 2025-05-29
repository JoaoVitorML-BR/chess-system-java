package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece getPiece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[row][column];
    }

    public Piece getPiece(Position position) { // Overloaded method to get a piece by its position
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // Set the piece's position
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        if (getPiece(position) == null) {
            return null; // No piece to remove
        }
        Piece aux = getPiece(position);
        aux.position = null; // Clear the piece's position
        pieces[position.getRow()][position.getColumn()] = null; // Remove the piece from the board
        return aux;
    }

    // Verify if a position is valid on the board
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return getPiece(position) != null;
    }

}
