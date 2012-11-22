package classics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 14:31
 */
public class Fibonnacci {
    private final boolean using_memo;
    private List<Integer> precalculated = new ArrayList<Integer>();

    public Fibonnacci(boolean using_memo) {
        this.using_memo = using_memo;
        precalculated.add(0);
        precalculated.add(1);
    }

    public int findIteratively(int n) {
        int size = precalculated.size();

        if (size >= n)
            return precalculated.get(n-1);

        int this_val = -1;
        int prev_val_1=precalculated.get(size-1);
        int prev_val_2=precalculated.get(size-2);

        for (int i=size; i < n; ++i) {
            this_val = prev_val_1 + prev_val_2;
            if (using_memo)
                precalculated.add(this_val);
            prev_val_2 = prev_val_1;
            prev_val_1 = this_val;
        }

        return this_val;
    }

    public int findRecursively(int n) {
        if (precalculated.size() >= n)
            return precalculated.get(n-1);
        int result = findRecursively(n-1) + findRecursively(n-2);
        if (using_memo)
            precalculated.add(result);
        return result;
    }
}
