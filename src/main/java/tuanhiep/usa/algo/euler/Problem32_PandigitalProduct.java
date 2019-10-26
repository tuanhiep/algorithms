package tuanhiep.usa.algo.euler;

import java.util.HashSet;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Problem32_PandigitalProduct {
    public static HashSet<Integer> digits = new HashSet<>();

    public static void main(String[] args) {
        initDigit(9);
        System.out.println(isPandigital("321", 3));
        System.out.println(isPandigital("391867254", 9));
        System.out.println(isProduct(7254, 9));
        System.out.println(sumdPandigitalProduct(9));
    }

    private static void initDigit(int n) {
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
    }
    // 1 digit * 4 digits = 4 digits => total 9 digits
    private static long sumdPandigitalProduct(int n) {
        long sum = 0;
        for (int i = 1; i < 99999; i++) {
            if (isProduct(i, 9)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isProduct(int number, int n) {
        for (int j = 1; j < Math.sqrt(number) + 1; j++) {
            if (number % j == 0) {
                int divisor = number / j;
                if (isPandigital(String.valueOf(j) + divisor + number, n)) {
                    return true;
                }
            }
        }
        return false;


    }

    private static boolean isPandigital(String product, int n) {
        if (product.length() != n) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < product.length(); i++) {
            set.add(Character.getNumericValue(product.charAt(i)));
        }

        if (set.size() != n) {
            return false;
        }
        set.removeAll(digits);
        if (set.size() > 0) {
            return false;
        }

        return true;


    }
}
