package tuanhiep.usa.algo.euler;

import java.util.HashSet;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem38_PandigitalMultiples {
    public static HashSet<Integer> memo = new HashSet<>();
    public static HashSet<Integer> digits = new HashSet<>();


    public static void main(String[] args) {
        initDigit();
        System.out.println(concatenateProduct(192, 3));
        System.out.println(findLargest(192));
        System.out.println(isPandigital(concatenateProduct(192, 3),9));
        System.out.println(findLargestPandigital());
    }

    private static void initDigit() {
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
    }

    private static long findLargestPandigital() {
        long max = 1;
        for (int i = 1; i < 10000; i++) {// Because if i exceed 10000 then i*1 and i*2 have total number of digits exceeds 9 digits
            long largest = findLargest(i);
            if (largest > max) {
                max = largest;
            }
        }
        return max;

    }

    private static long findLargest(int number) {

        long max = 123456789;
        int n = 1;
        int product = 1;
        while (n < 7) { // Because the min of number is 2, maximum of n is 7 so that the product doesn't exceed 9 digits
            product = concatenateProduct(number, n);
            if (product != -1 && isPandigital(product,9) && product > max && product < 999999999) {
                max = product;
            }
            n++;
        }
        return max;


    }

    private static boolean isPandigital(int product, int n) {
        String tocheck = String.valueOf(product);
        if (tocheck.length() != n) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < tocheck.length(); i++) {
            set.add(Character.getNumericValue(tocheck.charAt(i)));
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

    private static int concatenateProduct(int number, int n) {
        if (n == 1) {
            if (isPandigital(number,9)) {
                return number;
            }
            return -1;
        }

        String result = "";
        HashSet<Integer> comparingSet = (HashSet<Integer>) digits.clone();
        for (int i = 1; i <= n; i++) {
            int product = number * i;
            if (!validDigit(comparingSet, product)) {
                return -1;
            }
            result += String.valueOf(product);
        }
        return Integer.parseInt(result);

    }

    private static boolean validDigit(HashSet<Integer> comparingSet, int product) {
        String pro = String.valueOf(product);
        int size = pro.length();
        int initialSizeSet = comparingSet.size();
        for (int i = 0; i < size; i++) {
            comparingSet.remove(Character.getNumericValue(pro.charAt(i)));
        }
        if (initialSizeSet - comparingSet.size() != size) {
            return false;
        }
        return true;


    }


}
