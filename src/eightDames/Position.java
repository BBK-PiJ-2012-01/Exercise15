package eightDames;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:58
 */
public class Position {
    static private final int SIZE = 8;

    private final int row;
    private  final int column;

    public Position(int row, int column) {
        if (0 > row || row >= SIZE || 0 > column || column >= SIZE )
            throw new RuntimeException("Position not on board! " + row + "," + column);
        this.row = row;
        this.column = column;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    public String toString() {
        return String.format("(%d,%d)", row(),  column);
    }
}
