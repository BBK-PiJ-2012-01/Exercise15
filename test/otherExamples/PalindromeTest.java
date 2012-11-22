package otherExamples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:30
 */
public class PalindromeTest {
    @Test
    public void testIsPalindromic() throws Exception {
        assertTrue(Palindrome.isPalindromic(""));
        assertTrue(Palindrome.isPalindromic("a"));

        assertTrue(Palindrome.isPalindromic("aa"));
        assertFalse(Palindrome.isPalindromic("ab"));

        assertTrue(Palindrome.isPalindromic("abcba"));
        assertFalse(Palindrome.isPalindromic("abcca"));
    }
}
