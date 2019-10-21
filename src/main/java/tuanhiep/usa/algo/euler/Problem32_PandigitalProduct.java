package tuanhiep.usa.algo.euler;

import java.util.HashSet;

public class Problem32_PandigitalProduct {

    public static void main(String[] args) {
        System.out.println(isPandigital("391867254", 9));
        System.out.println(isProduct(7254, 9));
        System.out.println(sumdPandigitalProduct(9));
    }

    private static long sumdPandigitalProduct(int n) {
        long sum = 0;
        for (int i = 1; i < 9999; i++) {
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
                if (isPandigital(j + "" + divisor + "" + number, n)) {
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
        return true;


    }
}
