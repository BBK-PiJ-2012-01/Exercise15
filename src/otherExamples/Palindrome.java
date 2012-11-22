package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:27
 */
public class Palindrome {
    public static boolean isPalindromic(String str) {
        if (str.length() <= 1)
            return true;

        if (str.charAt(0) == str.charAt(str.length()-1))
            return isPalindromic(str.substring(1, str.length()-1));

        return false;
    }
}
