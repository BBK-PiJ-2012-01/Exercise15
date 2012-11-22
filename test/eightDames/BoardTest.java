package eightDames;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 22:21
 */
public class BoardTest {
    private Board board;

    @Before
    public void buildUp() {
        board = new Board();
    }

    @Test
    public void testClone() throws Exception {
        board.addMaden(new Position(0,0));
        board.addMaden(new Position(2,1));
        assertEquals(2, board.getTotalMadens());

        Board clone = board.clone();
        assertTrue(clone.isTaken(new Position(0,0)));
        assertTrue(clone.isTaken(new Position(2,1)));
        assertTrue(clone.isTaken(new Position(1,1)));
        assertTrue(clone.isTaken(new Position(5,1)));

        assertEquals(2, clone.getTotalMadens());
    }

    @Test
    public void testIsTaken() throws Exception {
        board.addMaden(new Position(0,0));
        board.addMaden(new Position(2,1));

        assertTrue(board.isTaken(new Position(0,0)));
        assertTrue(board.isTaken(new Position(2,1)));
        assertTrue(board.isTaken(new Position(1,1)));
        assertTrue(board.isTaken(new Position(5,1)));
    }

    @Test
    public void testAddMaden() throws Exception {
        board.addMaden(new Position(2,1));
    }

    @Test
    public void testReserve() throws Exception {
        board.reserve(new Position(5,5));
        assertTrue(board.isTaken(new Position(5, 5)));
        assertFalse(board.isTaken(new Position(5, 6)));
        assertFalse(board.isTaken(new Position(6,5)));
    }

    @Test
    public void testGetTotalMadens() throws Exception {
        assertEquals(0, board.getTotalMadens());
        board.addMaden(new Position(1, 1));
        assertEquals(1, board.getTotalMadens());
        board.addMaden(new Position(1,2));
        assertEquals(2, board.getTotalMadens());
    }

    @Test
    public void testIterator() throws Exception {
        int count = 0;
        for (Position pos : board) {
            ++count;
        }
        assertEquals(8*8, count);

        count = 0;
        board.addMaden(new Position(0,0));
        for (Position pos : board) {
            ++count;
        }
        System.out.println(board);
        assertEquals(7*7 - 7, count);
    }
}
