package otherExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 19/11/2012
 * Time: 15:38
 */
public class PaperSizes {
    private class BadInput extends Exception{}
    private int p;

    private int getPowerOfTwo(String input) throws BadInput {
        if (input.length() <= 1)
            throw new BadInput();

        if (input.charAt(0) != 'A')
            throw new BadInput();

        char first_digit_char = input.charAt(1);
        if (!Character.isDigit(first_digit_char))
             throw new BadInput();

        int first_digit = Character.getNumericValue(first_digit_char);
        if (first_digit > 0)
            return - first_digit;
        else {
            int number_of_zeros = 1;
            for (int i=2; i<input.length(); ++i) {
                if (input.charAt(i) == '0')
                    ++number_of_zeros;
                else
                    throw new BadInput();
            }
            return number_of_zeros - 1;
        }

    }

    public void printDimensions(String input) {
        try {
            p = getPowerOfTwo(input);
            System.out.format("%.0fmm x %.0fmm\n", 841*Math.pow(2,p), 1189*Math.pow(2,p));
        } catch (BadInput err) {
            System.out.format("Bad input: %s\n", input);
        }
    }

    public int getLastPowerOfTwo() {
        return p;
    }
}
