package classics;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 20/11/2012
 * Time: 00:35
 */
public class HanoiRedux {
    /*

    With n discs, this is the procedure to exchange the towers
    of even and odd disks: (note, [x] means stack of x discs).
    Moving a stack with a negative number of discs (eg. n = 2)
    means do nothing, as does moving a stack of discs greater
    than the total number of discs.

    move [1]
    move [2]
    move [3]
    ..
    move [n - 3]
  * move 2nd lowest
    move [n - 2]
  * move lowest
    move [n - 2]
  * move 2nd lowest
    move [n-3]
    ...
    move [3]
    move [2]
    move [1]


    The conditions before equate to doing the starred operations always
    (regardless of n) then moving stacks containing the following numbers
    of discs:
    for (int i = 1; i <= n-2; ++i) {
        move [i];
        move [i];      // NB. done twice because the procedure is symmetric.
    }

    The number of operations required to "move [i]" is ops=1 for i=1, then for
     each increment of i the number goes as "ops[i+1] = ops[i]*2 + 1"


     eg. n=6:



     1      2
     3      4
     5      6

     0

            1
            2
            3
            4
        5   6

     7

     move [4] = 15
     +1

     eg. n=8


     1      2
     3      4
     5      6
     7      8



    eg. n=10


     1      2
     3      4
     5      6
     7      8
     9      10
     11     12
     13     14
     15     16

     bottom-up moves (n=16):
                                             1 + 2 * {
                                                 + 1 + move[14]

     integrate left[7] -> right[6]               + 1 + move[12]
     integrate left[6] + right[6] -> centre      + 1 + move[11]
     integrate right[5] -> left[5]               + 1 + move[9]
     integrate left[5] + right[4] -> centre      + 1 + move[8]
     integrate left[4] -> right[3]               + 1 + move[6]
     integrate left[3] + right[3] -> centre      + 1 + move[5]
     integrate right[2] -> left[3]               + 1 + move[3]
     integrate left[2] + right[1] -> centre      + 1 + move[2]
     integrate left[1] -> right[0]               1
                                                }


     1      2
     3      4
     5      6
     7      8
     9      10
     11     12
     13     14

     bottom-up moves (n=14):
                                             1 + 2 * {
                                                 + 1 + move[12]

     integrate left[6] -> right[5]               + 1 + move[10]
     integrate left[5] + right[5] -> centre      + 1 + move[9]
     integrate right[4] -> left[4]               + 1 + move[7]
     integrate left[4] + right[3] -> centre      + 1 + move[6]
     integrate left[3] -> right[2]               + 1 + move[4]
     integrate left[2] + right[2] -> centre      + 1 + move[3]

     integrate right[1] -> left[1]               3
                                                }

    eg n=12

     1      2
     3      4
     5      6
     7      8
     9      10
     11     12                             1 + 2 * {
                                                + 1 + move[10]

    integrate left[5] -> right[4]               + 1 + move[8]
    integrate left[4] + right[4] -> centre      + 1 + move[7]
    integrate right[3] -> left[3]               + 1 + move[5]
    integrate left[3] + right[2] -> centre      + 1 + move[3]
    integrate left[2] -> right[1]               + 1 + move[2]
    integrate left[1] + right[1] -> centre      2
                                               }

    eg n=10

     1      2
     3      4
     5      6
     7      8
     9      10                                         1 + 2 * {
                                                + 1 + move[8]

    integrate left[4] -> right[3]               + 1 + move[6]
    integrate left[3] + right[3] -> centre      + 1 + move[5]
    integrate right[2] -> left[2]               + 1 + move[3]
    integrate left[2] + right[1] -> centre      + 1 + move[2]
    integrate left[1] -> right[0]               1
                                               }

    eg n=8

     1      2
     3      4
     5      6
     7      8
                                            1 + 2 * {
                                                + 1 + move[6]

    integrate left[3] -> right[2]               + 1 + move[4]
    integrate left[2] + right[2] -> centre      + 1 + move[3]
    integrate right[1] -> left[1]               3
                                               }


    eg n=6

     1      2
     3      4
     5      6

                                            1 + 2 * {
                                                + 1 + move[4]
    integrate left[2] -> right[1]               + 1 + move[2]
    integrate left[1] + right[1] -> centre      2


    //  SUMMARY
    integrate left[1] -> right[0]               1   (n = 10, 16) min_i = 2
    integrate right[1] -> left[1]               3   (n = 8, 14) min_i = 3
    integrate left[1] + right[1] -> centre      2   (n = 6, 12) min_i = 2
    //

     */

    public static int getNumberOfOps(int n) {
        int ops_to_move_i_discs = 0;
        System.out.format("-------- n = %d --------\n", n);
        //int ops = (n/2%2 == 1 && n > 2) ? 3 : 1;

        int ops, min_i;
        if (n == 2) {
            ops = 1;
            min_i = 1;
        } else if ((n / 2) % 3 == 0) {
            ops = 2;
            min_i = 2;
        } else if ((n / 2) % 3 == 1) {
            ops = 3;
            min_i = 3;
        } else {
            ops = 1;
            min_i = 2;
        }

        System.out.format(" start with %d\n", ops);

        for (int i= 1; i <= n-2; ++i) {
            ops_to_move_i_discs = ops_to_move_i_discs * 2 + 1;
            if ((n - i) % 3 == 0 || i < min_i)
                continue;
            System.out.format("+ 1 + move[%d]\n", i);
            ops += 1 + ops_to_move_i_discs;
        }

        return ops * 2 + 1;
    }

}
