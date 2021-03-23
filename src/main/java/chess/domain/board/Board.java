package chess.domain.board;

import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.piece.Pieces;
import chess.domain.piece.Position;

import java.util.List;

public class Board {
    public static final int ROW = 8;
    public static final int COLUMN = 8;

    private final Pieces pieces;

    private Board(final Pieces pieces) {
        this.pieces = pieces;
    }

    public Board(final List<Piece> pieces) {
        this(new Pieces(pieces));
    }

    public void movePiece(Color color, Position source, Position target) {
        Piece sourcePiece = pieces.findControllablePieceByPosition(color, source);
        catchPiece(color);
        sourcePiece.move(target, this);
    }

    private void catchPiece(final Color color) {
        pieces.catchPiece(color);
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }

    public List<Piece> getPieces() {
        return pieces.getPieces();
    }

    public double getWhiteScore() {
        return pieces.getWhiteScore();
    }

    public double getBlackScore() {
        return pieces.getBlackScore();
    }

    public boolean isCaughtKing() {
        return pieces.isCaughtKing();
    }

}
