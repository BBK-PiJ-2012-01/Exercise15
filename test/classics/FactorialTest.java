package classics;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 14:30
 */
public class FactorialTest {
    @Test
    public void testFindIteratively() throws Exception {
        assertEquals(120, Factorial.findIteratively(5));
    }

    @Test
    public void testFindRecursively() throws Exception {
        assertEquals(120, Factorial.findRecursively(5));
    }
}
