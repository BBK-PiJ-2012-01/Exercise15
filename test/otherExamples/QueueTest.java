package otherExamples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:25
 */
public class QueueTest {
    private Queue q;

    @Before
    public void setUp() throws Exception {
        q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
    }

    @Test
    public void testSizeIteratively() throws Exception {
        assertEquals(4, q.sizeIteratively());
    }

    @Test
    public void testSizeRecursively() throws Exception {
        assertEquals(4, q.sizeRecursively());
    }
}
