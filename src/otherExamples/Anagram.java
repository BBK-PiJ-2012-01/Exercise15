package otherExamples;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 23/11/2012
 * Time: 01:05
 */
public class Anagram {
    public static List<String> findAll(String input) {
        List<String> all_anagrams = new LinkedList<String>();
        if (input.isEmpty())
            return all_anagrams;

        char ch = input.charAt(0);
        String subword = copyExceptIndex(input, 0);

        List<String> subword_anagrams = findAll(subword);

        if (subword_anagrams.isEmpty()) {
            all_anagrams.add(String.valueOf(ch));
            return all_anagrams;
        }

        for (String anagram : subword_anagrams) {
            for (int i = 0; i < anagram.length(); ++i) {
                all_anagrams.add(anagram.substring(0, i) + ch + anagram.substring(i, anagram.length()));
            }
            all_anagrams.add(anagram + ch);
        }

        return all_anagrams;
    }

    public static String copyExceptIndex(String str, int index_to_ignore) {
        StringBuilder sbuf = new StringBuilder(str.length()-1);
        for (int i=0; i<str.length(); ++i) {
            if (i != index_to_ignore)
                sbuf.append(str.charAt(i));
        }
        return sbuf.toString();
    }
}
