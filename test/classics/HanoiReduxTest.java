package classics;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 20/11/2012
 * Time: 01:29
 */
public class HanoiReduxTest {
    @Test
    public void testGetNumberOfOps() throws Exception {
        assertEquals(3, HanoiRedux.getNumberOfOps2(2));
        assertEquals(11, HanoiRedux.getNumberOfOps2(4));
        assertEquals(45, HanoiRedux.getNumberOfOps2(6));
    }
}
