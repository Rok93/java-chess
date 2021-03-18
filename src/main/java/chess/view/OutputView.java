package chess.view;

import chess.view.dto.BoardDto;
import chess.view.dto.PieceDto;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final int BOARD_COLUMN_SIZE = 8;
    private static final String SCORE_FORMAT = "백: %.1f 흑: %.1f %n";
    private static final String EMPTY_BOARD_UNIT = ".";

    private OutputView() {
    }

    public static void drawBoard(final BoardDto boardDto) {
        String[] boardStatus = createBoardStatus(boardDto);

        int boardLength = boardStatus.length;
        for (int i = 0; i < boardLength; i++) {
            lineSeparatorIfSatisfyCondition(i);
            System.out.print(boardStatus[i]);
        }

        System.out.println();
    }

    private static String[] createBoardStatus(BoardDto boardDto) {
        String[] board = new String[boardDto.getColumn() * boardDto.getRow()];
        Arrays.fill(board, EMPTY_BOARD_UNIT);

        List<PieceDto> pieceDtos = boardDto.getPieceDtos();
        for (final PieceDto pieceDto : pieceDtos) {
            board[pieceDto.getRow() * BOARD_COLUMN_SIZE + pieceDto.getColumn()] = pieceDto.getNotation();
        }

        return board;
    }

    private static void lineSeparatorIfSatisfyCondition(final int lineSeparateThreshold) {
        if (lineSeparateThreshold % BOARD_COLUMN_SIZE == 0) {
            System.out.println();
        }
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    public static void printScore(final double whiteScore, final double blackScore) {
        System.out.printf(SCORE_FORMAT, whiteScore, blackScore);
    }

}
