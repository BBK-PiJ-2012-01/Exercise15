package classics;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 14:27
 */
public class Factorial {
    public static int findRecursively(int n) {
        if (n == 1)
            return 1;
        else
            return n * findRecursively(n-1);
    }

    public static int findIteratively(int n) {
        int result = n;
        while(n > 1) {
            result *= --n;
        }
        return result;
    }
}
