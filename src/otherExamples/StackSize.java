package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 23/11/2012
 * Time: 02:08
 */
public class StackSize {
    private static int method_calls;

    public static void test() {
        method_calls = 0;
        try {
            simple();
        } catch (StackOverflowError err) {
            System.out.format("Stack size = %d method calls\n", method_calls);
        }

        method_calls = 0;
        try {
            oneInt();
        } catch (StackOverflowError err) {
            System.out.format("Stack size = %d method calls (one int per call)\n", method_calls);
        }

        method_calls = 0;
        try {
            oneDouble();
        } catch (StackOverflowError err) {
            System.out.format("Stack size = %d method calls (one double per call)\n", method_calls);
        }
    }

    private static void simple() {
        ++method_calls;
        simple();
    }

    private static void oneInt() {
        ++method_calls;
        int a = 0;
        oneInt();
    }

    private static void oneDouble() {
        ++method_calls;
        double a = 0.;
        oneDouble();
    }
}
