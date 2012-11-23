package first;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 13:50
 */
public class ThinkingRecursivelyTest {
    private List<Integer> expected;

    private void setExpected(Integer[] expected_array) {
        expected = new ArrayList<Integer>(Arrays.asList(expected_array));
        ThinkingRecursively.clearOutput();
    }

    @Test
    public void testPrintNumbers() throws Exception {
        setExpected(new Integer[]{6,4,2,2,1,1,4,3,1,1,3,6});
        ThinkingRecursively.printNumbers(6);
        assertTrue(ThinkingRecursively.checkOutput(expected));
    }

    @Test
    public void testMcCarthy91() throws Exception {
        assertEquals((Integer) 91, Integer.valueOf(ThinkingRecursively.mcCarthy91(50)));
        assertEquals((Integer) 91, Integer.valueOf(ThinkingRecursively.mcCarthy91(73)));
        assertEquals((Integer) 91, Integer.valueOf(ThinkingRecursively.mcCarthy91(95)));
    }

    @Test
    public void testCheckOutput() throws Exception {
        setExpected(new Integer[]{3, 4, 5});

        ThinkingRecursively.println(3);
        ThinkingRecursively.println(4);
        ThinkingRecursively.println(5);

        assertTrue(ThinkingRecursively.checkOutput(expected));

        setExpected(new Integer[]{1,2,3});

        ThinkingRecursively.println(1);
        ThinkingRecursively.println(2);
        ThinkingRecursively.println(3);

        assertTrue(ThinkingRecursively.checkOutput(expected));

    }
}
