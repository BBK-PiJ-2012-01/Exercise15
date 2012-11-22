package first;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 13:41
 */
public class ThinkingRecursively {
    private static List<Integer> output = new LinkedList<Integer>();

    public static void printNumbers(int n) {
        if (n <= 0) {
            return;
        }
        println(n);
        printNumbers(n - 2);
        printNumbers(n - 3);
        println(n);
    }

    public String doggyMethod(int n) {
        String result = doggyMethod(n - 3) + n + doggyMethod(n - 2);

        // Recursion occurs before basis check!!!
        if (n <= 0) {
            return "";
        }

        return result;
    }

    public static String mcCarthy91(int n) {
        if (n > 100) {
            return "" + (n - 10);
        } else {
            return mcCarthy91(Integer.valueOf(mcCarthy91(n + 11)));
        }
    }

    public static void println(int num){
        output.add(num);
        System.out.println(num);
    }

    public static boolean checkOutput(List<Integer> expected) {
        return output.equals(expected);
    }

    public static void clearOutput() {
        output.clear();
    }
}
