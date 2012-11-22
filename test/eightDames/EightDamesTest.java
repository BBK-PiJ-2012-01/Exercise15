package eightDames;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 20:24
 */
public class EightDamesTest {
    @Test
    public void testGetFirstSolution() throws Exception {
        Board solution = EightDames.getFirstSolution();
        System.out.println(solution);
        assertNotNull(solution);
    }

    @Test
    public void testGetAllSolutions() throws Exception {
        List<Board> solutions = EightDames.getAllSolutions();

        for (Board board : solutions) {
            System.out.println(board);
        }

        System.out.format("Found %s boards.\n", solutions.size());
    }
}
