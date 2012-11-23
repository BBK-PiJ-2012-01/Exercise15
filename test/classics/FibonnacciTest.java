package classics;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 14:53
 */
public class FibonnacciTest {
    private Fibonnacci fib_memo, fib_nomemo;
    private List<Integer> first_ten = new LinkedList<Integer>(Arrays.asList(
            new Integer[] {0,1,1,2,3,5,8,13,21,34}));
    private LinkedList<Integer> calculated = new LinkedList<Integer>();
    private long counter;

    @Before
    public void setUp() throws Exception {
        fib_memo = new Fibonnacci(true);
        fib_nomemo = new Fibonnacci(false);
        calculated.clear();
    }

    @Test
    public void testFindIteratively() throws Exception {
        for (int n=1; n <= first_ten.size(); ++n) {
            calculated.add(fib_nomemo.findIteratively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testFindRecursively() throws Exception {
        for (int n=1; n <= first_ten.size(); ++n) {
            calculated.add(fib_nomemo.findRecursively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testMemoFindIteratively() throws Exception {
        for (int n=1; n <= first_ten.size(); ++n) {
            calculated.add(fib_memo.findIteratively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testMemoBackwardsFindIteratively() throws Exception {
        for (int n=first_ten.size(); n > 0; --n) {
            calculated.addFirst(fib_memo.findIteratively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testMemoFindRecursively() throws Exception {
        for (int n=1; n <= first_ten.size(); ++n) {
            calculated.add(fib_memo.findRecursively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testMemoBackwardsFindRecursively() throws Exception {
        for (int n=first_ten.size(); n > 0; --n) {
            calculated.addFirst(fib_memo.findRecursively(n));
        }
        assertTrue(calculated.equals(first_ten));
    }

    @Test
    public void testIterativeTiming() {
        startCounter();
        fib_nomemo.findIteratively(40);
        fib_nomemo.findIteratively(45);
        System.out.format("Iterative (no memo) took %dns\n", stopCounter());

        startCounter();
        fib_memo.findIteratively(40);
        fib_memo.findIteratively(45);
        System.out.format("Iterative (memo) took %dns\n", stopCounter());
    }

    @Test
    public void testRecursiveTiming() {
        startCounter();
        fib_nomemo.findRecursively(40);
        fib_nomemo.findRecursively(45);
        System.out.format("Recursive (no memo) took %dns\n", stopCounter());

        startCounter();
        fib_memo.findRecursively(40);
        fib_memo.findRecursively(45);
        System.out.format("Recursive (memo) took %dns\n", stopCounter());
    }

    private void startCounter() {
        counter = System.nanoTime();
    }

    private long stopCounter() {
        return System.nanoTime() - counter;
    }
}
