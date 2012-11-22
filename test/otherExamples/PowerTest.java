package otherExamples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:36
 */
public class PowerTest {
    @Test
    public void testPow_recursive() throws Exception {
        assertEquals(27, Power.pow_recursive(3, 3));
        assertEquals(3, Power.pow_recursive(3, 1));
    }

    @Test
    public void testPow_iterative() throws Exception {
        assertEquals(27, Power.pow_iterative(3, 3));
        assertEquals(3, Power.pow_iterative(3, 1));
    }
}
