package classics;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 15:27
 */
public class HanoiTowers {
    static int getMinNumberOfMoves(int n) {
        int result = 1;
        for (int i=1; i<n; ++i) {
            result = result * 2 + 1;
        }
        return result;
    }
}
