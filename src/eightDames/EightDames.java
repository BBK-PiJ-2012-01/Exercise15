package eightDames;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:43
 */
public class EightDames {
    private static final int DAMES = 8;

    public static Board getFirstSolution() {
        return getFirstSolution(new Board());
    }

    private static Board getFirstSolution(Board board) {
        if (board.getTotalMadens() == DAMES) {
            return board;
        }

        Board child_board, solved_board;

        for (Position pos : board) {
            child_board = board.clone();
            child_board.addMaden(pos);
            solved_board = getFirstSolution(child_board);

            if (solved_board != null)
                return solved_board;

            board.reserve(pos);
        }

        return null;
    }

    public static List<Board> getAllSolutions() {
        return getAllSolutions(new Board());
    }

    private static List<Board> getAllSolutions(Board board) {
        List<Board> good_boards = new LinkedList<Board>();

        if (board.getTotalMadens() == DAMES) {
            good_boards.add(board);
            return good_boards;
        }

        Board child_board;

        for (Position pos : board) {
            child_board = board.clone();
            child_board.addMaden(pos);
            good_boards.addAll(getAllSolutions(child_board));
            board.reserve(pos);
        }

        return good_boards;
    }
}
