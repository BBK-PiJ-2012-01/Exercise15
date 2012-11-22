package eightDames;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 19:16
 */
public class BoardIterator implements Iterator<Position> {
    private Position next;
    private final Board board;

    public BoardIterator(Board board) {
        this.board = board;
        findNext();
    }

    private void findNext() {
        int row, col;
        try {
            row = next.row();
            col = next.column();
        } catch (NullPointerException err) {
            row = -1;
            col = 0;
        }

        do {
            if (++row >= 8) {
                row = 0;
                ++col;
                if (col >= 8) {
                    next = null;
                    return;
                }
            }

            next = new Position(row, col);

        } while (board.isTaken(next));
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Position next() {
        Position pos_to_return = next;
        findNext();
        return pos_to_return;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
