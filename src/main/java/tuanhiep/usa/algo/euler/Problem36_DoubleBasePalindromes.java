package tuanhiep.usa.algo.euler;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem36_DoubleBasePalindromes {
    public static void main(String[] args) {
        System.out.println(isDoublePalindrome(585));
        System.out.println(findSumDoubleBasePalindromes(1000000));

    }

    private static long findSumDoubleBasePalindromes(int upper) {
        long sum = 0;
        for (int i = 0; i < upper; i++) {
            if (isDoublePalindrome(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isDoublePalindrome(int number) {
        String numDecimal = String.valueOf(number);
        String numBinary = Integer.toBinaryString(number);
        return isPalindrome(numDecimal) && isPalindrome(numBinary);

    }

    private static boolean isPalindrome(String number) {
        int index = 0;
        while (index < number.length() / 2) {
            if (number.charAt(index) != number.charAt(number.length() - 1 - index)) {
                return false;
            }
            index++;
        }
        return true;


    }
}
