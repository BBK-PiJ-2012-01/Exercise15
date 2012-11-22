package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 16:33
 */
public class Power {
    public static int pow_recursive(int base, int exponent) {
        if (exponent == 1)
            return base;
        return base * pow_recursive(base, exponent-1);
    }

    public static int pow_iterative(int base, int exponent) {
        int result = base;
        for (int i=1; i<exponent; ++i) {
            result *= base;
        }
        return result;
    }
}
