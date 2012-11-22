package otherExamples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:01
 */
public class PaperSizesTest {
    private PaperSizes obj = new PaperSizes();

    @Test
    public void testSmallPaper() throws Exception {
        obj.printDimensions("A1");
        assertEquals(-1, obj.getLastPowerOfTwo());

        obj.printDimensions("A2");
        assertEquals(-2, obj.getLastPowerOfTwo());
    }

    @Test
    public void testStandardPaper() throws Exception {
        obj.printDimensions("A0");
        assertEquals(0, obj.getLastPowerOfTwo());
    }

    @Test
    public void testLargePaper() throws Exception {
        obj.printDimensions("A00");
        assertEquals(1, obj.getLastPowerOfTwo());

        obj.printDimensions("A000");
        assertEquals(2, obj.getLastPowerOfTwo());
    }
}
