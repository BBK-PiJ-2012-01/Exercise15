package otherExamples;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 23/11/2012
 * Time: 01:56
 */
public class AnagramTest {
    @Test
    public void testFindAll() throws Exception {
        Set<String> expected = new HashSet<String>();
        expected.add("abc");
        expected.add("acb");
        expected.add("bac");
        expected.add("bca");
        expected.add("cab");
        expected.add("cba");

        assertEquals(expected, new HashSet<String>(Anagram.findAll("abc")));
    }

    @Test
    public void testSingleCharacter() throws Exception {
        Set<String> expected = new HashSet<String>();
        expected.add("a");

        assertEquals(expected, new HashSet<String>(Anagram.findAll("a")));
    }

    @Test
    public void testEmptyString() throws Exception {
        assertTrue(Anagram.findAll("").isEmpty());
    }

    @Test
    public void testCopyExceptIndex() throws Exception {
        assertEquals("bc", Anagram.copyExceptIndex("abc", 0));
        assertEquals("ac", Anagram.copyExceptIndex("abc", 1));
        assertEquals("ab", Anagram.copyExceptIndex("abc", 2));

        assertEquals("", Anagram.copyExceptIndex("a", 0));
    }
}
