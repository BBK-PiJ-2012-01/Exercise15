package eightDames;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:45
 */
public class Board implements Iterable<Position>  {
    private boolean[][] madens = new boolean[8][8];
    private boolean[][] taken = new boolean[8][8];
    private int total_madens = 0;

    public Board() {
        for (int col=0; col<8; ++col) {
            for (int row=0; row<8; ++row) {
                madens[col][row] = false;
                taken[col][row] = false;
            }
        }
    }

    private Board(Board b) {
        for (int col=0; col<8; ++col) {
            madens[col] = b.madens[col].clone();
            taken[col] = b.taken[col].clone();
        }
        total_madens = b.total_madens;
    }

    public Board clone() {
        return new Board(this);
    }

    public boolean isTaken(Position pos) {
        return taken[pos.column()][pos.row()];
    }

    public void addMaden(Position pos) {
        madens[pos.column()][pos.row()] = true;
        ++total_madens;

        int diag_column;

        for (int i=0; i<8; ++i) {
            taken[pos.column()][i] = true;

            // diag_column - pos.column = ± (diag_row - pos.row)
            // (thought diag_row = i)
            diag_column = pos.column() + (pos.row() - i);
            if (0 <= diag_column && diag_column < 8)
                taken[diag_column][i] = true;

            diag_column = pos.column() - (pos.row() - i);
            if (0 <= diag_column && diag_column < 8)
                taken[diag_column][i] = true;
        }

        for (int j=0; j<8; ++j) {
            taken[j][pos.row()] = true;
        }

    }

    public void reserve(Position pos) {
        taken[pos.column()][pos.row()] = true;
    }

    public String toString() {
        StringBuffer output = new StringBuffer();
        for (int col=0; col<33; ++col) {
            output.append('-');
        }
        output.append('\n');
        String border = output.toString();

        for (int row=0; row<8; ++row) {
            output.append("| ");
            for (int col=0; col<8; ++col) {
                // output.append(madens[col][row] ? '+' : taken[col][row]? '*' : ' ');
                output.append(madens[col][row] ? '+' : ' ');
                output.append(" | ");
            }
            output.append('\n');
            output.append(border);
        }

        return output.toString();
    }
    
    public int getTotalMadens() {
        return total_madens;
    }

    @Override
    public Iterator<Position> iterator() {
        return new BoardIterator(this);
    }
}
