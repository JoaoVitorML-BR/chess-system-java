package chess;

import boardgame.Piece;
import boardgame.Position;
import boardgame.Board;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().getPiece(position);
        return p != null && p.getColor() != color; // Check if the piece exists and is of a different color

    }
}
