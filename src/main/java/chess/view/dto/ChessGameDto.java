package chess.view.dto;

import chess.domain.game.ChessGame;

import java.util.List;
import java.util.stream.Collectors;

public class ChessGameDto {
    private boolean isFinished;
    private List<PieceDto> pieceDtos;
    private String state;

    public ChessGameDto(final boolean isFinished) {
        this.isFinished = isFinished;
        pieceDtos = null;
    }

    public ChessGameDto(final ChessGame chessGame) {
        isFinished = chessGame.isFinished();
        pieceDtos = chessGame.getBoard().getPieces().stream()
                .map(PieceDto::new)
                .collect(Collectors.toList());
        state = chessGame.getState().getValue();

    }

    public String getState() {
        return state;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public List<PieceDto> getPieceDtos() {
        return pieceDtos;
    }

}
